package Day16_HW;

import java.util.Scanner;

public class BinaryGap {
	private static Scanner scanner = new Scanner(System.in);

	public static int longestBinaryGap(int N) {
		String binary = Integer.toBinaryString(N);
		int maxGap = 0;
		int currentGap = 0;
		boolean count = false;

		for (char c : binary.toCharArray()) {
			if (c == '1') {
				if (count) {
					maxGap = Math.max(maxGap, currentGap);
				}
				count = true;
				currentGap = 0;
			} else if (count) {
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
