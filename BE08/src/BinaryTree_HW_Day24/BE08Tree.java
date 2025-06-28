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
}