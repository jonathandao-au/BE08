package OOP;

import java.util.Scanner;

public class Console {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Student[] students = new Student[100];
		Mentor[] mentors = new Mentor[100];
		int studentCount = 0;
		int mentorCount = 0;

		System.out.println("LOGIN");
		System.out.println();
		System.out.print("ID: ");
		String id = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();
		
		while (true) {
			System.out.println("MENU");
			System.out.println();
			System.out.println("1. Register a new student");
			System.out.println("2. Register a new mentor");
			System.out.println("3. View all students and mentors");
			System.out.println("4. Exit");
			System.out.println();
			System.out.print("Input: ");

			String choice = scanner.nextLine();

			if (choice.equals("1")) {
				System.out.print("Student Name: ");
				String name = scanner.nextLine();

				System.out.print("Student Gmail: ");
				String gmail = scanner.nextLine();

				System.out.print("Student Phone: ");
				String phone = scanner.nextLine();

				students[studentCount] = new Student(name, gmail, phone);
				studentCount++;
				System.out.println("Student registered successfully.");
				System.out.println();

			} else if (choice.equals("2")) {
				System.out.print("Mentor Name: ");
				String name = scanner.nextLine();

				System.out.print("Mentor Years of experience: ");
				int years = Integer.parseInt(scanner.nextLine());

				mentors[mentorCount] = new Mentor(name, years);
				mentorCount++;
				System.out.println("Mentor registered successfully.");
				System.out.println();

			} else if (choice.equals("3")) {
				System.out.println("List of Students: ");
				for (int i = 0; i < studentCount; i++) {
					students[i].showInfo();
					System.out.println();
				}

				System.out.println("List of Mentors: ");
				for (int i = 0; i < mentorCount; i++) {
					mentors[i].showInfo();
					System.out.println();
				}

			} else {
				System.out.println("Exiting program.");
				break;
			}
		}

		scanner.close();
	}
}
