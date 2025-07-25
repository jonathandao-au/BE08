package Day29_HW;

import java.util.Arrays;
import java.util.Scanner;

// Maximum of 6! permutations = O(1)?
public class ValidTime {
	public static String validTime(int[] digits) {
		Arrays.sort(digits);
		String earliest = null;

		do {
			boolean valid = (digits[0] <= 2) && 
							(digits[0] != 2 || digits[1] <= 3) && 
							(digits[2] <= 5) && 
							(digits[4] <= 5);

			if (valid) {
				String time = "" + digits[0] + digits[1] + ":" + digits[2] + digits[3] + ":" + digits[4] + digits[5];

				if (earliest == null || time.compareTo(earliest) < 0) {
					earliest = time;
				}
			}
		} while (nextPermutation(digits));

		return earliest != null ? earliest : "INVALID";
	}

	private static boolean nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1])
			i--;
		if (i < 0)
			return false;

		int j = nums.length - 1;
		while (nums[j] <= nums[i])
			j--;

		swap(nums, i, j);
		reverse(nums, i + 1, nums.length - 1);
		return true;
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void reverse(int[] a, int i, int j) {
		while (i < j)
			swap(a, i++, j--);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter 6 digits (0-9) separated by spaces:");

		int[] digits = new int[6];
		for (int i = 0; i < 6; i++) {
			int d = scanner.nextInt();
			if (d < 0 || d > 9) {
				System.out.println("An invalid value was entered.");
				return;
			}
			digits[i] = d;
		}
		scanner.close();

		String result = validTime(digits);
		System.out.println("Earliest valid time: " + result);
	}
}
