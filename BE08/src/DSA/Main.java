package DSA;

import java.util.ArrayList;
import java.util.Calendar;

// Day 15 - 21 May 2025.

public class Main {

	public static int findDataIndex(int[] arr, int value) {
		for (int i = 0; i < 10; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public static int findDataIndex2(int[] arr, int value) {
		return -1;
	}

	public static int findDataIndex3(int[] arr, int value) {
		for (int i = 0; i < 10; i++) {
			int index = i;
			if (index >= arr.length) {
				index = 0;
			}
			if (arr[index] == value) {
				return i;
			}
		}
		return -1;
	}

	public static int findDataIndex4(int[] arr, int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] arg) {
		int value = 4;
		int valueb = 502;

		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] arrb = new int[10000];
		int number = arr[1];

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.get(1);

		// These are functionally the same.

		// Array - Collection - Data Structure: A data type contains multiple data.

		long startTime = Calendar.getInstance().getTimeInMillis();
		int result = findDataIndex(arr, value);
		long endTime = Calendar.getInstance().getTimeInMillis();
		long processTime = endTime - startTime;

		long startTime2 = Calendar.getInstance().getTimeInMillis();
		int result2 = findDataIndex2(arr, value);
		long endTime2 = Calendar.getInstance().getTimeInMillis();
		long processTime2 = endTime2 - startTime2;

		long startTime3 = Calendar.getInstance().getTimeInMillis();
		int result3 = findDataIndex3(arr, value);
		long endTime3 = Calendar.getInstance().getTimeInMillis();
		long processTime3 = endTime3 - startTime3;

		long startTime4 = Calendar.getInstance().getTimeInMillis();
		int result4 = findDataIndex4(arr, value);
		long endTime4 = Calendar.getInstance().getTimeInMillis();
		long processTime4 = endTime4 - startTime4;
		
		long startTimeb = Calendar.getInstance().getTimeInMillis();
		int resultb = findDataIndex(arrb, valueb);
		long endTimeb = Calendar.getInstance().getTimeInMillis();
		long processTimeb = endTimeb - startTimeb;

		long startTime2b = Calendar.getInstance().getTimeInMillis();
		int result2b = findDataIndex2(arrb, valueb);
		long endTime2b = Calendar.getInstance().getTimeInMillis();
		long processTime2b = endTime2b - startTime2b;

		long startTime3b = Calendar.getInstance().getTimeInMillis();
		int result3b = findDataIndex3(arrb, valueb);
		long endTime3b = Calendar.getInstance().getTimeInMillis();
		long processTime3b = endTime3b - startTime3b;

		long startTime4b = Calendar.getInstance().getTimeInMillis();
		int result4b = findDataIndex4(arrb, valueb);
		long endTime4b = Calendar.getInstance().getTimeInMillis();
		long processTime4b = endTime4b - startTime4b;

		System.out.println("findDataIndex = " + processTime);
		System.out.println("findDataIndex2 = " + processTime2);
		System.out.println("findDataIndex3 = " + processTime3);
		System.out.println("findDataIndex4 = " + processTime4);
		System.out.println();
		System.out.println("findDataIndexb = " + processTimeb);
		System.out.println("findDataIndex2b = " + processTime2b);
		System.out.println("findDataIndex3b = " + processTime3b);
		System.out.println("findDataIndex4b = " + processTime4b);
	}
	
	// Time Complexity - O(1*x)
		// Algorithms = Functions???
		// bigO
	
	public static int testFunc01 (int[] arr, int value) {
		int a = 1;
		int b = 2;
		int sum = 0;
		sum = a + b;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + i;
		}
		return sum;
	}
	
	// 7 operations
	// arr.length = 1 => 10
	// arr.length = 2 => 13
	// arr.length = 3 => 16
	// arr.length = n => 7 + 3*n O(3n + 7) - Linear Time Complexity (On) - Linear Time - Loops
	
	public static int testFunc02 (int[] arr, int value) {
		int a = 1;
		int b = 2;
		int sum = 0;
		sum = a + b;
		return sum;
	}
	
	// 5 operations - O(5) - Constant Time Complexity (O1) Constant Time - No loops - Mostly positive.
	
	// Quadratic
	
	// Omega Theta?
	
	// Depends on available info, predictability vs flexibility.
}
