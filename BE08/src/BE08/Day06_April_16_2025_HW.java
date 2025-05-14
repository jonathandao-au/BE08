package BE08;

public class Day06_April_16_2025_HW {

	// HW 6.1

	public static int solutionHW6_1(int[] A) {
		int index = 0;
		int jumps = 0;
		boolean[] used = new boolean[A.length]; // boolean variables are usually named with passive voice.

		while (index >= 0 && index < A.length) {
			if (used[index] == true) {
				return -1;
			}

			used[index] = true;
			int distance = A[index];
			index = index + distance;
			jumps++;
		}

		return jumps;
	}

	// HW 6.2 - METHOD A: SORT WHEN NEEDED.

	public static int solutionHW6_2_a(int[] A, int K) {
		if (K > A.length)
			return -2;

		int[] maxKs = new int[K];
		boolean[] used = new boolean[A.length];
		int sum = 0;

		for (int i = 0; i < K; i++) {
			int max = 0;
			int maxIndex = -1;
			for (int j = 0; j < A.length; j++) {
				if (used[j] == false && A[j] > max) {
					max = A[j];
					maxIndex = j;
				}
			}
			maxKs[i] = max;
			used[maxIndex] = true;
			sum = sum + max;
		}

		if (sum % 2 == 0) {
			return sum;
		}

		// Swapping (K <=> A) min even with max odd OR min odd with max even.

		int minOdd_K = -1;
		int minEven_K = -1;
		int maxOdd_A = -1;
		int maxEven_A = -1;
		// -1 means not available.

		for (int i = 0; i < A.length; i++) {
			boolean usedA = used[i];
			boolean evenA = A[i] % 2 == 0;
			int value = A[i];

			if (usedA == true && evenA == true && (minEven_K == -1 || value < minEven_K)) {
				minEven_K = value;
			} else if (usedA == true && evenA == false && (minOdd_K == -1 || value < minOdd_K)) {
				minOdd_K = value;
			} else if (usedA == false && evenA == true && (maxEven_A == -1 || value > maxEven_A)) {
				maxEven_A = value;
			} else if (usedA == false && evenA == false && (maxOdd_A == -1 || value > maxOdd_A)) {
				maxOdd_A = value;
			}
		}

		int sum2 = 0;

		if (minOdd_K != -1 && maxEven_A != -1) {
			sum2 = Math.max(sum2, sum - minOdd_K + maxEven_A);
		}

		if (minEven_K != -1 && maxOdd_A != -1) {
			sum2 = Math.max(sum2, sum - minEven_K + maxOdd_A);
		}

		return sum2;
	}

	// HW 6.2 - METHOD B: PREEMPTIVE SORT

	public static int solutionHW6_2_b(int[] A, int K) {
		if (K > A.length)
			return -2;

		// Descending sort

		for (int i = 0; i < A.length - 1; i++) {
			for (int j = 0; j < A.length - i - 1; j++) {
				if (A[j] < A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;
				}
			}
		}

		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += A[i];
		}
		if (sum % 2 == 0) {
			return sum;
		}

		int min_K = A[K - 1];
		boolean evenMin_K = min_K % 2 == 0;

		for (int i = K; i < A.length; i++) {
			if ((A[i] % 2 == 0) != evenMin_K) {
				int sum2 = sum - min_K + A[i];
				return sum2;
			}
		}

		return -1;
	}

	// RESULT

	public static void main(String[] args) {

		// HW 6.1 result

		System.out.println("HW 6.1");
		int[] A6_1 = { 2, 3, -1, 1, 3 };
		if (solutionHW6_1(A6_1) == -1) {
			System.out.println("The pawn jumps infinitely.");
		} else {
			System.out.println("The pawn jumps " + solutionHW6_1(A6_1) + " times.");
		}

		// HW 6.2 - Method A result

		System.out.println();
		System.out.println("HW 6.2 - METHOD A: SORT WHEN NEEDED");
		int[] A6_2_a = { 2, 4, 6, 8, 9 };
		int K_a = 3;
		if (solutionHW6_2_a(A6_2_a, K_a) == -1) {
			System.out.println("There is no valid even sum.");
		} else if (solutionHW6_2_a(A6_2_a, K_a) == -2) {
			System.out.println("K cannot be larger than the number of elements in the array.");
		} else {
			System.out.println("Largest possible even sum of K = " + K_a + " elements in the array = "
					+ solutionHW6_2_a(A6_2_a, K_a) + ".");
		}

		// HW 6.2 - Method B result

		System.out.println();
		System.out.println("HW 6.2 - METHOD B: PREEMPTIVE SORTING");
		int[] A6_2_b = { 2, 4, 6, 8, 9 };
		int K_b = 3;
		if (solutionHW6_2_b(A6_2_b, K_b) == -1) {
			System.out.println("There is no valid even sum.");
		} else if (solutionHW6_2_b(A6_2_b, K_b) == -2) {
			System.out.println("K cannot be larger than the number of elements in the array.");
		} else {
			System.out.println("Largest possible even sum of K = " + K_b + " elements in the array = "
					+ solutionHW6_2_b(A6_2_b, K_b) + ".");

		}
	}
}