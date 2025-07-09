package BST;

public class Main {
	 public static void main(String[] args) {
	        BST tree = new BST();

	        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
	        for (int val : values) {
	            tree.insert(val);
	        }

	        System.out.println("Balanced BST: ");
	        tree.printBST();
	    }
}
