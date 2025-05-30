package Day16_HW;

import java.util.Scanner;

public class SameDiceSumManual {
	public static int minDiceTurns(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < A.length; i++)
			sumA += A[i];
		for (int i = 0; i < B.length; i++)
			sumB += B[i];

		if (sumA > sumB) {
			return minDiceTurns(B, A);
		}

		int diff = sumB - sumA;
		if (diff == 0)
			return 0;

		int[] gains = new int[A.length + B.length];
		int index = 0;

		for (int i = 0; i < A.length; i++) {
			gains[index++] = 6 - A[i];
		}

		for (int i = 0; i < B.length; i++) {
			gains[index++] = B[i] - 1;
		}

		for (int i = 0; i < gains.length - 1; i++) {
			for (int j = 0; j < gains.length - i - 1; j++) {
				if (gains[j] < gains[j + 1]) {
					int temp = gains[j];
					gains[j] = gains[j + 1];
					gains[j + 1] = temp;
				}
			}
		}

		int steps = 0;
		for (int i = 0; i < gains.length; i++) {
			diff -= gains[i];
			steps++;
			if (diff <= 0)
				return steps;
		}

		return -1;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of dice in array A: ");
		int n = scanner.nextInt();
		scanner.nextLine();
		int[] A = new int[n];
		System.out.println("Enter values for A: ");
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		System.out.println();

		System.out.print("Enter number of dice in array B: ");
		int m = scanner.nextInt();
		int[] B = new int[m];
		System.out.println("Enter values for B: ");
		for (int i = 0; i < m; i++) {
			B[i] = scanner.nextInt();
		}

		System.out.println();
		int result = minDiceTurns(A, B);
		if (result == -1) {
			System.out.println("It's imposible for the two array to have the same sum.");
		} else {
			System.out.println("Minimum number of dice to turn: " + result);
		}
	}
}
