package BE08;

public class Day05_April12_2025 {
	public static void main(String[] args) {
		int[] arrInt = { 3, 8, 6, 7 };
		int index = 0;
		int index2 = 0;
		int index3 = 0;
		System.out.println(arrInt);
		System.out.println();

		// [I@65b3120a is the reference address. Specifically it's the address for arrInt[0].

		while (index < arrInt.length) {
			System.out.print(arrInt[index] + " ");
			index = index + 1;
		}
		System.out.println();
		System.out.println();

		// index = index + 1; is an updation line. This needs to exist to allow loop functions to stop.
		// Without it, the loop will be an infinite loop.
		// This allows loop control (by how many iterations).

		do {
			System.out.print(arrInt[index2] + " ");
			index2 = index2 + 1;
		} while (index2 < arrInt.length);
		// while (index2 != 0);
		System.out.println();
		System.out.println();

		// This loop runs for 5 iterations and would fail at the fifth with while (index2 != 0);
		// Do - while runs the first iteration condition notwithstanding, only then checks the while to decide if it will loop again.

		for (index3 = 0; index3 < arrInt.length; index3++) {
			System.out.print(arrInt[index3] + " ");
		}
		System.out.println();
		System.out.println();

		// For integrates updation line into the the argument. Different syntax-wise but functionally the same as while.
		// The initialization and updation can be put outside. The difference between for and while is purely readability and preference.

		int resize = 3;
		int[] temp = new int[resize];
		int index4 = 0;

		for (int i = 0; i < resize; i++) {
			temp[index4] = arrInt[i];
			index4++;
		}
		arrInt = temp;
		System.out.print("New size: ");
		for (int i = 0; i < arrInt.length; i++) {
			System.out.print(arrInt[i] + " ");
		}

		System.out.println();
		System.out.println();
		
		int[] clone = java.util.Arrays.copyOf(arrInt, resize);
		System.out.print("New size: ");
		for (int i = 0; i < clone.length; i++) {
			System.out.print(clone[i] + " ");
			
			
		// 	
		// These 2 methods create a new array with the desirable size in Heap, then copy values from arrInt. These 2 arrays have 2 different addresses.
			
		// Optimizing codes by reducing loop iterations.
			
		}
	}
}
