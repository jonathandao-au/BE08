package BinaryTree;

public class BE08Main {
	public static void main(String[] args) {
		BE08Node root = new BE08Node(1);
		root.left = new BE08Node(2);
		root.right = new BE08Node(3);
		root.left.left = new BE08Node(4);
		root.left.left.left = new BE08Node(5);

        BE08Tree tree = new BE08Tree(root);

        System.out.println("Is tree balanced? " + tree.isBalanced());

        for (BE08Node node : tree.findImbalanceNodes()) {
            System.out.println("Imbalanced at node with value: " + node.value);
        }
    }
}