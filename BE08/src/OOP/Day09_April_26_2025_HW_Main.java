package OOP;

import java.util.Scanner;

public class Day09_April_26_2025_HW_Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Student[] students = new Student[100];
		Mentor[] mentors = new Mentor[100];
		int studentCount = 0;
		int mentorCount = 0;

		while (true) {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Register New Student");
			System.out.println("2. Register New Mentor");
			System.out.println("3. View All Students and Mentors");
			System.out.println("Other. Exit");
			System.out.print("Enter your choice: ");

			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.print("Student Name: ");
				String name = scanner.nextLine();

				System.out.print("Student Gmail: ");
				String gmail = scanner.nextLine();

				System.out.print("Student Phone: ");
				String phone = scanner.nextLine();

				if (studentCount < 100) {
					students[studentCount] = new Student(name, gmail, phone);
					studentCount++;
					System.out.println("Student registered successfully.");
				} else {
					System.out.println("Student list is full.");
				}

			} else if (choice.equals("2")) {
				System.out.print("Mentor Name: ");
				String name = scanner.nextLine();

				System.out.print("Mentor Years of experience: ");
				int years = Integer.parseInt(scanner.nextLine());

				if (mentorCount < 100) {
					mentors[mentorCount] = new Mentor(name, years);
					mentorCount++;
					System.out.println("Mentor registered successfully.");
				} else {
					System.out.println("Mentor list is full.");
				}

			} else if (choice.equals("3")) {
				System.out.println("\n--- List of Students ---");
				for (int i = 0; i < studentCount; i++) {
					students[i].showInfo();
				}

				System.out.println("\n--- List of Mentors ---");
				for (int i = 0; i < mentorCount; i++) {
					mentors[i].showInfo();
				}

			} else {
				System.out.println("Exiting program. Goodbye!");
				break;
			}
		}

		scanner.close();
	}
}
