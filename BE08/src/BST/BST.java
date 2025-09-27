package BST;

import java.util.LinkedList;

public class BST {
    Node root;

    public BST() {
        this.root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);

        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        updateHeight(node);
        return balance(node);
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    private int getHeight(Node node) {
        return (node == null) ? 0 : node.height;
    }

    private int getBalanceFactor(Node node) {
        return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    // AVL balancing
    private Node balance(Node node) {
        int balance = getBalanceFactor(node);

        // Left heavy
        if (balance > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                return rotateRight(node); // LL case
            } else {
                node.left = rotateLeft(node.left); // LR case
                return rotateRight(node);
            }
        }

        // Right heavy
        if (balance < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                return rotateLeft(node); // RR case
            } else {
                node.right = rotateRight(node.right); // RL case
                return rotateLeft(node);
            }
        }

        return node;
    }

    private Node rotateLeft(Node z) {
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        updateHeight(z);
        updateHeight(y);

        return y;
    }

    private Node rotateRight(Node z) {
        Node y = z.left;
        Node T3 = y.right;

        y.right = z;
        z.left = T3;

        updateHeight(z);
        updateHeight(y);

        return y;
    }

    public void buildBST(int[] nums) {
        for (int num : nums) {
            insert(num);
        }
    }

    public void printBST() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(current.value + " ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        System.out.println();
    }
}