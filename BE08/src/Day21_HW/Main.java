package Day21_HW;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BE08Tree tree = new BE08Tree(null);
		BE08Node root = new BE08Node(1);
		root.value = 1;

		tree.root = root;
		BE08Node node = new BE08Node(1);
		node.value = 30;
		tree.root.children.add(node);

		node = new BE08Node(1);
		node.value = 40;
		tree.root.children.add(node);

		node = new BE08Node(1);
		node.value = 20;
		BE08Node findNode = tree.nodeSearchBFS(30);
		findNode.children.add(node);

		node = new BE08Node(1);
		node.value = 10;
		findNode = tree.nodeSearchDFS(30);
		findNode.children.add(node);

		node = new BE08Node(1);
		node.value = 50;
		findNode = tree.nodeSearchDFS(10);
		findNode.children.add(node);
		
		node = new BE08Node(1);
		node.value = 60;
		findNode = tree.nodeSearchDFS(50);
		findNode.children.add(node);

		node = new BE08Node(1);
		node.value = 70;
		findNode = tree.nodeSearchDFS(50);
		findNode.children.add(node);

		System.out.println("1. BFS Search");
		System.out.println("2. DFS Search");
		System.out.println("3. DFS Search with Recursion");

		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Choose an option: ");
		int choice = scanner.nextInt();

		if (choice == 1) {
			System.out.print("Search for: ");
			int search = scanner.nextInt();
			BE08Node resultBFS = tree.nodeSearchBFS(search);
			if (resultBFS != null) {
				System.out.println("BFS Search for " + search + " : Found " + resultBFS.value + ".");
			} else {
				System.out.println("BFS Search for " + search + " : Not found.");
			}
		} else if (choice == 2) {
			System.out.print("Search for: ");
			int search = scanner.nextInt();
			BE08Node resultDFS = tree.nodeSearchDFS(search);
			if (resultDFS != null) {
				System.out.println("DFS Search for " + search + " : Found " + resultDFS.value + ".");
			} else {
				System.out.println("DFS Search for " + search + " : Not found.");
			}
		} else if (choice == 3) {
			System.out.print("Search for: ");
			int search = scanner.nextInt();
			BE08Node resultDFS = tree.nodeSearchDFSRecursive(search);
			if (resultDFS != null) {
				System.out.println("DFS Search with Recursion for " + search + " : Found " + resultDFS.value + ".");
			} else {
				System.out.println("DFS Search with Recursion for " + search + " : Not found.");
			}
		} else {
			System.out.println("Invalid option.");
		}
		scanner.close();
	}
}
