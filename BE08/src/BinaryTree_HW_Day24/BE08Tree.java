package BinaryTree;

import java.util.ArrayList;

public class BE08Tree {
    BE08Node root;

    public BE08Tree(BE08Node root) {
        this.root = root;
    }

    public boolean isBalanced() {
        return findImbalanceNodes().isEmpty();
    }

    public ArrayList<BE08Node> findImbalanceNodes() {
        ArrayList<BE08Node> result = new ArrayList<>();
        checkBalance(root, result);
        return result;
    }

    private int checkBalance(BE08Node node, ArrayList<BE08Node> imbalanced) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left, imbalanced);
        int rightHeight = checkBalance(node.right, imbalanced);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            imbalanced.add(node);
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public void rebalance() {
        root = rebalanceNode(root);
    }

    private BE08Node rebalanceNode(BE08Node node) {
        if (node == null) return null;

        node.left = rebalanceNode(node.left);
        node.right = rebalanceNode(node.right);

        int balance = height(node.left) - height(node.right);

        if (balance > 1) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateRight(node);
            } else {
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        } else if (balance < -1) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateLeft(node);
            } else {
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private int height(BE08Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    private BE08Node rotateLeft(BE08Node x) {
        if (x == null || x.right == null) return x;

        BE08Node y = x.right;
        BE08Node T2 = y.left;

        y.left = x;
        x.right = T2;

        return y;
    }

    private BE08Node rotateRight(BE08Node y) {
        if (y == null || y.left == null) return y;

        BE08Node x = y.left;
        BE08Node T2 = x.right;

        x.right = y;
        y.left = T2;

        return x;
    }
