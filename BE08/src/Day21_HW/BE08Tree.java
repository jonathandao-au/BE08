package Day21_HW;

import java.util.ArrayList;

public class BE08Tree {
    BE08Node root;

    public BE08Tree(BE08Node root) {
        this.root = root;
    }

    // Breadth-First Search (BFS)
    if (root == null) return null;

    LinkedList<BE08Node> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        BE08Node current = queue.removeFirst();

        if (current.value == value) return current;

        queue.addAll(current.children);
    }

    return null;
}

    // Depth-First Search (DFS)
    public BE08Node nodeSearchDFS(int value) {
        if (root == null) return null;

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
}
