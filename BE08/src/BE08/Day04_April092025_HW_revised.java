package BE08;

public class Day04_April092025_HW_revised {
	public static void main(String[] args) {

		// HW 4.1

		int[] arr = { 3, 8, 5, 2, 9, 10, 7, 6, 5, 5};

		int evenCount = 0;
		int oddCount = 0;
		int evenSum = 0;
		int oddSum = 0;

		for (int i = 0; i < arr.length; i = i + 1) {
			if (arr[i] % 2 == 0) {
				evenCount = evenCount + 1;
				evenSum = evenSum + arr[i];
			} else {
				oddCount = oddCount + 1;
				oddSum = oddSum + arr[i];
			}
		}

		System.out.println("There are " + evenCount + " even numbers. Sum = " + evenSum);
		System.out.println("There are " + oddCount + " odd numbers. Sum = " + oddSum);
		System.out.println();

		// HW 4.2

		int min = arr[0];
		int max = arr[0];

		for (int i = 1; i < arr.length; i = i + 1) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		System.out.println("Smallest number = " + min);
		System.out.println("Largest number = " + max);
		System.out.println();

		// HW 4.3

		for (int i = 0; i < arr.length - 1; i = i + 1) {
			for (int j = 0; j < arr.length - i - 1; j = j + 1) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.print("Sorted array in ascending order: ");
		for (int i = 0; i < arr.length; i = i + 1) {
			System.out.print(arr[i] + " ");
		}
	}
}