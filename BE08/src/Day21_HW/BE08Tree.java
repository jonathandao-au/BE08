package Day21_HW;

import java.util.ArrayList;
import java.util.LinkedList;

public class BE08Tree {
	BE08Node root;

	public BE08Tree(BE08Node root) {
		this.root = root;
	}

	// Breadth-First Search (BFS)
	public BE08Node nodeSearchBFS(int value) {
		if (root == null)
			return null;

		LinkedList<BE08Node> listChildren = new LinkedList<>();
		listChildren.add(root);

		while (!listChildren.isEmpty()) {
			BE08Node currentNode = listChildren.removeFirst();

			if (currentNode.value == value) {
				return currentNode;
			}

			listChildren.addAll(currentNode.children);
		}

		return null;
	}

	// Depth-First Search (DFS)
	public BE08Node nodeSearchDFS(int value) {
		if (root == null)
			return null;

		ArrayList<BE08Node> listChildren = new ArrayList<>();
		listChildren.add(root);

		while (!listChildren.isEmpty()) {
			BE08Node currentNode = listChildren.remove(listChildren.size() - 1);

			if (currentNode.value == value) {
				return currentNode;
			}

			for (int i = currentNode.children.size() - 1; i >= 0; i--) {
				listChildren.add(currentNode.children.get(i));
			}
		}

		return null;
	}

	// Depth-First Search with Recursion
	
	public BE08Node nodeSearchDFSRecursive(int value) {
        return DFSRecursive(root, value);
    }
	
	private BE08Node DFSRecursive(BE08Node node, int value) {
		if (node == null)
			return null;

		if (node.value == value) {
			return node;
		}

		for (BE08Node child : node.children) {
			BE08Node result = DFSRecursive(child, value);
			if (result != null) {
				return result;
			}
		}

		return null;
	}
}
