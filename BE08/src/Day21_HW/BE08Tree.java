package Day21_HW;

import java.util.ArrayList;

public class BE08Tree {
    BE08Node root;

    public BE08Tree(BE08Node root) {
        this.root = root;
    }

    // Breadth-First Search (BFS)
        public BE08Node nodeSearchBFS(int value) {
        if (root == null) return null;

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
