package Day16_HW;

import java.util.Scanner;

public class BinaryGapManual {

	private static Scanner scanner = new Scanner(System.in);

	public static int longestBinaryGap(int N) {
		int[] binaryDigits = new int[32]; // Cuz 32-bit.
		int index = 0;

		while (N > 0) {
			binaryDigits[index++] = N % 2;
			N /= 2;
		}

		int maxGap = 0;
		int currentGap = 0;
		boolean counting = false;

		for (int i = index - 1; i >= 0; i--) {
			if (binaryDigits[i] == 1) {
				if (counting) {
					if (currentGap > maxGap) {
						maxGap = currentGap;
					}
				}
				counting = true;
				currentGap = 0;
			} else if (counting) {
				currentGap++;
			}
		}

		return maxGap;
	}

	public static void main(String[] args) {
		System.out.print("N = ");
		Integer N = scanner.nextInt();
		scanner.nextLine();
		if (N < 1) {
			System.out.println("Invalid input.");
		} else {
			System.out.println("The longest binary gap of N has the length of " + longestBinaryGap(N) + ".");
		}
	}
}