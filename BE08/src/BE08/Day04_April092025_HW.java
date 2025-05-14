package BE08;

public class Day04_April092025_HW {
	public static void main(String[] args) {

		// HW 4.1

		int[] arr1 = { 3, 8, 5, 12, 7, 6, 10, 1 };

		int evenCount = 0;
		int oddCount = 0;
		int evenSum = 0;
		int oddSum = 0;

		for (int num : arr1) {
			if (num % 2 == 0) {
				evenCount++;
				evenSum += num;
			} else {
				oddCount++;
				oddSum += num;
			}
		}

		System.out.println("Even Count = " + evenCount + ", Even Sum = " + evenSum);
		System.out.println("Odd Count = " + oddCount + ", Odd Sum = " + oddSum);
		System.out.println();

		// HW 4.2

		int[] arr2 = { 4, 1, 9, 2, 10, 3 };

		int min2 = arr2[0];
		int max2 = arr2[0];

		for (int i2 = 1; i2 < arr2.length; i2 = i2 + 1) {
			if (arr2[i2] < min2) {
				min2 = arr2[i2];
			}
			if (arr2[i2] > max2) {
				max2 = arr2[i2];
			}
		}

		System.out.println("Minimum value = " + min2);
		System.out.println("Maximum value = " + max2);
		System.out.println();

		// HW 4.3

		int[] arr3 = { 5, 2, 9, 1, 6 };

		for (int i3 = 0; i3 < arr3.length - 1; i3 = i3 + 1) {
			int minIndex = i3;

			for (int j3 = i3 + 1; j3 < arr3.length; j3 = j3 + 1) {
				if (arr3[j3] < arr3[minIndex]) {
					minIndex = j3;
				}
			}

			int temp = arr3[i3];
			arr3[i3] = arr3[minIndex];
			arr3[minIndex] = temp;
		}

		System.out.print("Sorted array (ASC): ");
		for (int num : arr3) {
			System.out.print(num + " ");
		}
	}

}
