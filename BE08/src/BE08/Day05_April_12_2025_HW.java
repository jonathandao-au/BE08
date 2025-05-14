package BE08;

public class Day05_April_12_2025_HW {

	// HW 5.1

	public static boolean isPalindrome(int[] arrPal) {
		int bottom = 0;
		int top = arrPal.length - 1;
		while (bottom < top) {
			if (arrPal[bottom] != arrPal[top]) {
				return false;
			}
			bottom++;
			top--;
		}
		return true;
	}

	// HW 5.2

	public static boolean isPrimeNumber(int number) {
		if (number <= 1)
			return false;

		for (int divisor = 2; divisor < number / 2; divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		return true;
	}

	// HW 5.3

	public static int singleNumber(int[] nums) {
		int max = nums.length;
		int[] count = new int[max + 1];

		for (int i = 0; i < max; i++) {
			count[nums[i]]++;
		}

		for (int i = 1; i <= max; i++) {
			if (count[i] == 1) {
				return i;
			}
		}
		return -1;
	}

	// RESULTS

	public static void main(String[] args) {
		int[] arrPal = { 25, 50, 100, 100, 50, 25 };
		System.out.println("Is the array palindrome? => " + isPalindrome(arrPal));

		int number = 173;
		System.out.println("Is " + number + " a prime number? => " + isPrimeNumber(number));

		int[] nums = { 6, 1, 2, 1, 2, 6, 6 };
		if (singleNumber(nums) == -1) {
			System.out.println("There is no single number in the array.");
		} else {
			System.out.println("The single number is: " + singleNumber(nums));
		}
	}
}