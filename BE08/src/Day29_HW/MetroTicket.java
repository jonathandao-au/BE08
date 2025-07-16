package Day29_HW;

import java.util.Scanner;

// n = A.length. O(n). Max O(30)?
public class MetroTicket {
	public static int metroTicket(int[] A) {
		boolean[] travel = new boolean[31]; // Day 1 - 30, ignoring index 0.
		for (int day : A) {
			travel[day] = true;
		}

		int[] dp = new int[31];
		for (int i = 1; i <= 30; i++) {
			if (!travel[i]) {
				dp[i] = dp[i - 1];
			} else {
				int cost1 = dp[i - 1] + 2;
				int cost7 = dp[Math.max(0, i - 7)] + 7;
				int cost30 = 25;

				dp[i] = Math.min(cost1, Math.min(cost7, cost30));
			}
		}

		return dp[30];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter number of travel days in the upcoming month: ");
		int n = scanner.nextInt();
		int[] A = new int[n];

		System.out.println("Enter travel days (between 1 and 30): ");
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		int cost = metroTicket(A);
		System.out.println("Minimum cost: $" + cost);
	}
}
