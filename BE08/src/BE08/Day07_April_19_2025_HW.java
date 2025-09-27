package BE08;

public class Day07_April_19_2025_HW {

	// HW 7.1
	// Since headStart + tailStart will always = A.length.
	// An alternative would be using only headStart and compare that with A.length -
	// headStart. (Need more testing)
	//

	public static int solutionHW7_1(int[] A) {
		int headStart = 0;
		int tailStart = 0;
		for (int i = 0; i < A.length; i++) {
			int binary = i % 2;
			if (A[i] != binary) {
				headStart++;
			}
			if (A[i] != 1 - binary) {
				tailStart++;
			}
		}

		return Math.min(headStart, tailStart);
	}

	// HW 7.2
	// An alternative is to ascending sort first then do incremental conditions.
	// But avoid using sort since it takes more work and processing.

	public static int solutionHW7_2(int[] A) {
		boolean[] isDuplicated = new boolean[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			if (A[i] < 1 || A[i] > A.length) {
				return -1;
			}
			if (isDuplicated[A[i]]) {
				return 0;
			}
			isDuplicated[A[i]] = true;
		}

		return 1;
	}

	// HW 7.3
	// Hint: Ascending and Descending
	// To find the largest gap between the values, adding the largest while subtracting the smallest, skipping the in-between.

	public static int solutionHW7_3(int[] A) {
		long evenSum = 0;
		long oddSum = 0;

		for (int i = 0; i < A.length; i++) { // {1, 2, 3, 3, 2, 1, 5}
			long evenSum_updated = Math.max(evenSum, oddSum + A[i]);
			long oddSum_updated = Math.max(oddSum, evenSum - A[i]);
			evenSum = evenSum_updated;
			oddSum = oddSum_updated;
			System.out.println("Iteration: A[" + i + "] = " + A[i]);
			System.out.println("evenSum = " + evenSum);
			System.out.println("oddSum = " + oddSum);
			System.out.println();
		}

		long result = Math.max(evenSum, oddSum);
		if (result >= 1000000000) {
			result = result % 1000000000;
		}

		return (int) result;
	}

	// HW 7.3 Extra

	// RESULTS

	public static void main(String[] args) {
		System.out.println("HW 7.1");
		int[] A_7_1 = { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 };
		int result_7_1 = solutionHW7_1(A_7_1);
		System.out.println("A minumum of " + result_7_1 + " coin(s) are flipped.");
		System.out.println();
		System.out.println("HW 7.2");
		int[] A_7_2 = { 1, 3, 5, 7, 9, 2, 4, 6, 8, 10 };
		int result_7_2 = solutionHW7_2(A_7_2);
		if (result_7_2 == -1) {
			System.out.println("The array is invalid.");
		}
		if (result_7_2 == 0) {
			System.out.println("The array is not a permutation.");
		} else {
			System.out.println("The array is a permutation.");
		}
		System.out.println();
		System.out.println("HW 7.3");
		int[] A_7_3 = { 1, 2, 3, 2, 1, 1, 2, 2, 5, 3, 4, 6, 1 };
		int result_7_3 = solutionHW7_3(A_7_3);
		System.out.println("Sum = " + result_7_3);
	}
}
