package BE08;

public class Day06_April_16_2025 {
	public static void main(String[] args) {

		// Data types with the capitalised first letter is of reference type (Integer, Double, etc.).
		// These data types come along with their utilities and functions, hence taking up more memory rather than a fixed amount like primitive types.
		// Primitive data types are suitable for simple calculations.
		// Reference data types are utilised alongside with their corresponding functions from the library.
		// An array with a preset primitive data type will have fixed-size boxes to store it's corresponding data.
		// An array with a preset reference data type will store addresses for it's data in boxes instead of actual values.

		Integer[] arrNum1 = { 1, 2, 3, 4 };
		int[] arrNum2 = { 1, 2, 3, 4 };

		System.out.println(arrNum1[0]);
		System.out.println(arrNum2[0]);
		
		int num = 5;
		int num2 = 5;
		System.out.println(++num2); // = 6
		System.out.println(num++);  // = 5
		
		// ++num2 prioritises the increment and returns the value before printing
		// num++ prioritises returning the value (which still = 5), printing the value out then does the increment later.
		
		int[] arrNum3 = {7, 28, 56, 100, 275, 862, 999};
		int target = 862;
		int left = 0;
		int right = arrNum3.length - 1;
		int mid = (left + right) / 2;
		
		while (left <= right) {
			if (target < arrNum3[mid]) {
				right = mid - 1;
			} else if (target > arrNum3[mid]) {
				left = mid + 1;
			} else if (target == arrNum3[mid]) {
				System.out.println(mid);
				break;
			}
		}
		// Find which box the target value is stored in the array.
		// It's best to use Binary Search for this.
		
		
	}
}
