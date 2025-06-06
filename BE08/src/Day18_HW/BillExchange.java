package Day18_HW;

import java.util.Scanner;

public class BillExchange {
	public static int exchange (int amount) {
		int [] denominations = { 500000, 200000, 100000, 50000, 20000, 10000, 5000, 2000, 1000 };
		int count = 0;
		
		if (amount < 1000) return 0;
		
		for (int i = 0; i < denominations.length;i++) {
			int bill = denominations[i];
			if (amount >= bill) {
				int countBills = amount / bill;
				count += countBills;
				amount = amount % bill;
			}
		}
		return count;
	}
	
		public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your amount: ");
		int amount = scanner.nextInt();
		scanner.nextLine();
		int result = exchange(amount);
		System.out.println("The minimum amount of bills exchanged: " + result);
	}
}

// Time Complexity O(9)
// Space Complexity O(13)