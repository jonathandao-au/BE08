-- UTILIZE EXPLAIN AND ANALYZE TO LEARN HOW MYSQL WORKS - VERY IMPORTANT.

-- 1. Show film over 100mins
-- Simple filter using WHERE. Uses index scan if length_min is indexed.
SELECT *
FROM film
WHERE length_min > 100;

-- 2. Which film over average length of all films
-- Subquery calculates average once; outer query filters above that.
SELECT *
FROM film
WHERE length_min > (SELECT AVG(length_min) FROM film);

-- 3. Which film has name start with letter 't'
-- LIKE 't%' matches names starting with 't' (case-insensitive by default if collation allows).
SELECT *
FROM film
WHERE name LIKE 't%';

-- 4. Which film contain letter 'a'
-- LIKE '%a%' finds 'a' anywhere in the name.
SELECT *
FROM film
WHERE name LIKE '%a%';

-- 5. How many film in US?
-- COUNT(*) counts rows. WHERE filters by country_code.
-- COUNT(*) counts null rows as well whereas others don't.
-- COUNT(*) is O(1) while COUNT(attribute) is O(n). (*) is just array.length while (attribute) is a null-checking loop.
-- Use COUNT(*) when data within is not a concern.
SELECT COUNT(*) AS total_us_films
FROM film
WHERE country_code = 'US';

-- 6. Longest and shortest length of all film
-- MIN and MAX are aggregate functions, scanning only once.
SELECT MIN(length_min) AS shortest, MAX(length_min) AS longest
FROM film;

-- UNION??? Merged columns share the same data type 

-- 7. Unique film types (NO DUPLICATE)
-- DISTINCT removes duplicates from the type column.
SELECT DISTINCT type
FROM film;
-- OR 
SELECT type
FROM film
GROUP BY type;

-- 8. Distance (in days) between 1st and last film screening
-- HAVING COUNT(*) > 2
-- SELECT - FROM - WHERE - GROUP BY - HAVING
-- NEETCODE practicals
-- QUERY OF EXECUTION
-- MANY-TO-ONE will have indexed primary keys on ONE => O(1) complexity for select/call.
-- Prioritize indexing primary keys with a smaller loop of a table (containing less data).
-- Frequently changing data should be represented by seconds.
-- 

SELECT film.id, film.name, IFNULL(MAX(DATE(start_time)) - MIN(DATE(start_time)),0) FROM film LEFT JOIN screening ON film.id = screening.film_id GROUP BY film.id, film.name;

-- 9. All Screening Information for film "Tom&Jerry"
-- JOIN to match film and room for full info.
-- SUBQUERY without INDEX?
-- WHERE applies before JOINING

SELECT s.*, f.name AS film_name, r.name AS room_name
FROM screening s
JOIN film f ON s.film_id = f.id
JOIN room r ON s.room_id = r.id
WHERE f.name = 'Tom&Jerry';

-- OR EXPLICIT (Better logic)

SELECT f.name as film_name, r.name as room_name, s.start_time
FROM film f 
JOIN screening s ON f.id = s.film_id
JOIN room r ON r.id = s.room_id 
WHERE f.name = 'Tom&Jerry';

-- OR IMPLICIT (Not recommended, LEFT/RIGHT JOIN don't work properly)

SELECT f.name as film_name, r.name as room_name, s.start_time
FROM film f 
JOIN screening s
JOIN room r
WHERE f.name = 'Tom&Jerry'AND f.id = s.film_id AND r.id = s.room_id;

-- 10. All screening in two given days
-- Use IN() for multiple dates.
SELECT *
FROM screening
WHERE DATE(start_time) IN ('2022-05-25', '2022-05-26');

-- 11. Films without any screening
-- LEFT JOIN keeps all films; NULL in screening means no match.
SELECT f.*
FROM film f
LEFT JOIN screening s ON f.id = s.film_id
WHERE s.id IS NULL;

-- 12. Who booked more than 1 seat in the same booking
-- GROUP BY booking_id and filter HAVING > 1 seat_id.
-- You don't have to SELECT and GROUP BY the same columns all the time.
-- Usually you should use GROUP BY with IDs, as they represent rows and references from other tables.
-- Consider adding a subquery SELECT DISTINCT/ GROUP BY + SUM to account for multiple bookings from one person.
SELECT b.id AS booking_id, c.first_name, c.last_name, COUNT(rs.seat_id) AS seats_quantity
FROM booking b
JOIN customer c ON b.customer_id = c.id
JOIN reserved_seat rs ON b.id = rs.booking_id
GROUP BY b.id
HAVING COUNT(rs.seat_id) > 1;

-- 13. Rooms showing more than 2 films in one day
-- GROUP BY room and date, count distinct films.
SELECT r.name AS room_name, DATE(s.start_time) AS show_date, COUNT(DISTINCT s.film_id) AS films_count
FROM screening s
JOIN room r ON s.room_id = r.id
GROUP BY r.id, DATE(s.start_time)
HAVING COUNT(DISTINCT s.film_id) > 2;

-- 14. Which room shows the least number of films
-- Count distinct films per room; ORDER BY ascending, LIMIT 1 for least.
SELECT r.name, COUNT(DISTINCT s.film_id) AS total_films
FROM screening s
JOIN room r ON s.room_id = r.id
GROUP BY r.id
ORDER BY total_films ASC
LIMIT 1;

-- This doesn't account for multiple rooms having the same least amount.

-- OR

SELECT r.name, COUNT(DISTINCT s.film_id) AS total_films
FROM screening s
JOIN room r ON s.room_id = r.id
GROUP BY r.id
HAVING COUNT(DISTINCT s.film_id) = (
    SELECT MIN(films_per_room) FROM (
        SELECT COUNT(DISTINCT film_id) AS films_per_room
        FROM screening
        GROUP BY room_id
    ) AS t
);

SELECT room_id, total_films
FROM (SELECT room_id, COUNT(DISTINCT film_id) AS total_films
	FROM screening
	GROUP BY room_id) AS t
WHERE total_films = (SELECT COUNT(DISTINCT film_id) AS total_film
					 FROM screening
                     GROUP BY room_id
                     ORDER BY total_films
                     LIMIT 1);

-- OR

-- Common Table Expression

WITH cte_room_total_film AS (
	SELECT room_id, COUNT(DISTINCT film_id) AS total_films
	FROM screening
	GROUP BY room_id
)
SELECT room_id, total_films
FROM cte_room_total_film
WHERE total_films = (SELECT MIN(total_films) FROM cte_room_total_film);

-- 15. Films without booking
-- LEFT JOIN through screening to booking.
SELECT DISTINCT f.*
FROM film f
LEFT JOIN screening s ON f.id = s.film_id
LEFT JOIN booking b ON s.id = b.screening_id
WHERE b.id IS NULL;

-- 16. Film shown in the biggest number of rooms
-- Count distinct room_id for each film; pick top one.
SELECT f.name, COUNT(DISTINCT s.room_id) AS rooms_count
FROM screening s
JOIN film f ON s.film_id = f.id
GROUP BY f.id
ORDER BY rooms_count DESC
LIMIT 1;

-- 17. Number of films shown on each day of week, ordered descending
-- DAYNAME returns weekday; count distinct films per weekday.
SELECT DAYNAME(start_time) AS weekday, COUNT(DISTINCT film_id) AS films_count
FROM screening
GROUP BY weekday
ORDER BY films_count DESC;

-- 18. Total length of each film shown on 2022-05-28
-- Join film to screening, filter by date, sum lengths.
SELECT f.name, SUM(f.length_min) AS total_minutes
FROM screening s
JOIN film f ON s.film_id = f.id
WHERE DATE(s.start_time) = '2022-05-28'
GROUP BY f.id;

-- 19. Films with showing time above and below average
-- Compare SUM(length) per film with overall avg SUM(length) per film.
WITH film_times AS (
    SELECT f.id, f.name, SUM(f.length_min) AS total_time
    FROM screening s
    JOIN film f ON s.film_id = f.id
    GROUP BY f.id
),
avg_time AS (
    SELECT AVG(total_time) AS avg_total FROM film_times
)
SELECT ft.*, 
       CASE 
           WHEN ft.total_time > at.avg_total THEN 'Above Average'
           WHEN ft.total_time < at.avg_total THEN 'Below Average'
           ELSE 'Equal Average'
       END AS comparison
FROM film_times ft, avg_time at;

-- 20. Room with least number of seats
SELECT r.name, COUNT(se.id) AS seat_count
FROM room r
JOIN seat se ON r.id = se.room_id
GROUP BY r.id
ORDER BY seat_count ASC
LIMIT 1;

-- 21. Rooms with seats above average seat count
WITH seat_counts AS (
    SELECT r.id, r.name, COUNT(se.id) AS seat_count
    FROM room r
    JOIN seat se ON r.id = se.room_id
    GROUP BY r.id
),
avg_seats AS (
    SELECT AVG(seat_count) AS avg_count FROM seat_counts
)
SELECT sc.*
FROM seat_counts sc, avg_seats a
WHERE sc.seat_count > a.avg_count;

-- 22. Seats Mr. Dung CAN book besides his reserved seats in booking id = 1
-- Get all seats in the same room, exclude ones booked by Dung.
SELECT s.*
FROM seat s
WHERE s.room_id = (
    SELECT sc.room_id
    FROM screening sc
    JOIN booking b ON sc.id = b.screening_id
    WHERE b.id = 1
)
AND s.id NOT IN (
    SELECT rs.seat_id
    FROM reserved_seat rs
    WHERE rs.booking_id = 1
);

-- 23. Film with total screenings > 10, ordered by total screenings
SELECT f.name, COUNT(s.id) AS total_screenings
FROM film f
JOIN screening s ON f.id = s.film_id
GROUP BY f.id
HAVING COUNT(s.id) > 10
ORDER BY total_screenings DESC;

-- 24. TOP 3 days of week based on total bookings
SELECT DAYNAME(sc.start_time) AS weekday, COUNT(b.id) AS total_bookings
FROM booking b
JOIN screening sc ON b.screening_id = sc.id
GROUP BY weekday
ORDER BY total_bookings DESC
LIMIT 3;

-- 25. Booking rate over screenings for each film, ordered by rate
-- Rate = total bookings / total screenings.
WITH film_stats AS (
    SELECT f.id, f.name,
           COUNT(DISTINCT s.id) AS total_screenings,
           COUNT(b.id) AS total_bookings
    FROM film f
    JOIN screening s ON f.id = s.film_id
    LEFT JOIN booking b ON s.id = b.screening_id
    GROUP BY f.id
)
SELECT id, name,
       total_bookings / total_screenings AS booking_rate
FROM film_stats
ORDER BY booking_rate DESC;

-- 26. Which film has rate over/below/equal average (from Q25)
WITH film_stats AS (
    SELECT f.id, f.name,
           COUNT(DISTINCT s.id) AS total_screenings,
           COUNT(b.id) AS total_bookings
    FROM film f
    JOIN screening s ON f.id = s.film_id
    LEFT JOIN booking b ON s.id = b.screening_id
    GROUP BY f.id
),
film_rates AS (
    SELECT id, name,
           total_bookings / total_screenings AS booking_rate
    FROM film_stats
),
avg_rate AS (
    SELECT AVG(booking_rate) AS avg_booking_rate FROM film_rates
)
SELECT fr.*,
       CASE 
           WHEN fr.booking_rate > ar.avg_booking_rate THEN 'Above Average'
           WHEN fr.booking_rate < ar.avg_booking_rate THEN 'Below Average'
           ELSE 'Equal Average'
       END AS comparison
FROM film_rates fr, avg_rate ar;

-- 27. TOP 2 people who enjoy the least total TIME in cinema (only with bookings)
SELECT c.first_name, c.last_name, SUM(f.length_min) AS total_minutes
FROM booking b
JOIN customer c ON b.customer_id = c.id
JOIN screening s ON b.screening_id = s.id
JOIN film f ON s.film_id = f.id
GROUP BY c.id
ORDER BY total_minutes ASC
LIMIT 2;
