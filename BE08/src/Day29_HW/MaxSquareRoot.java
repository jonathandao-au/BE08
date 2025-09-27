package Day29_HW;

import java.util.Scanner;

// Checking maximum to 2^29 so a maximum of 29 loops. O(1)?
public class MaxSquareRoot {
	public static int maxOperations(int A, int B) {
		int maxChainLength = 0;
		for (int k = 1;; k++) {
			long start = (long) Math.ceil(Math.pow(A, 1.0 / (1 << k)));
			long end = (long) Math.floor(Math.pow(B, 1.0 / (1 << k)));

			if (start > end || end < 2) {
				break;
			}

			maxChainLength = k;
		}

		return maxChainLength;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter A (start of interval - min 2): ");
		int A = scanner.nextInt();
		System.out.print("Enter B (end of interval - max 1,000,000,000): ");
		int B = scanner.nextInt();

		int result = maxOperations(A, B);
		System.out.println("Max square root operations: " + result);
	}
}
