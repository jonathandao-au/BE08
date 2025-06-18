package Day21_HW;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BE08Node root = new BE08Node(1);
		BE08Node node2 = new BE08Node(2);
		BE08Node node3 = new BE08Node(3);
		BE08Node node4 = new BE08Node(4);
		BE08Node node5 = new BE08Node(5);

		root.addChild(node2);
		root.addChild(node3);
		node2.addChild(node4);
		node3.addChild(node5);

		BE08Tree tree = new BE08Tree(root);

		System.out.println("1. BFS Search");
		System.out.println("2. DFS Search");

		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Choose an option: ");
		int choice = scanner.nextInt();

		if (choice == 1) {
			System.out.print("Search for: ");
			int node = scanner.nextInt();
			BE08Node resultBFS = tree.nodeSearchBFS(node);
			if (resultBFS != null) {
				System.out.println("BFS Search for " + node + "  Found " + resultBFS.value + ".");
			} else {
				System.out.println("BFS Search for " + node + "  Not found.");
			}
		} else if (choice == 2) {
			System.out.print("Search for: ");
			int node = scanner.nextInt();
			BE08Node resultDFS = tree.nodeSearchDFS(node);
			if (resultDFS != null) {
				System.out.println("DFS Search for " + node + " : Found " + resultDFS.value + ".");
			} else {
				System.out.println("DFS Search for " + node + " : Not found.");
			}
		} else {
			System.out.println("Invalid option.");
		}
		scanner.close();
	}
}