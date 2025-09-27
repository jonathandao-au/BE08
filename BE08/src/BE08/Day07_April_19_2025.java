package BE08;

public class Day07_April_19_2025 {
	public static void main(String[] args) {

		System.out.println("HW 3");
		System.out.println();

		// Finding square root of number without using Math.sqrt - Revised from HW 3

		// BINARY SEARCH - Generally ideal for searching problems.

		System.out.println("BINARY SEARCH");
		double number1 = 36;
		double left = 0;
		double right = number1;
		double mid = (left + right) / 2;
		double deviation = 0.01;
		int loop1 = 0;

		if (number1 <= 0) {
			System.out.println("The number must be positive.");
			return;
		}
		do {
			if (mid * mid > number1) {
				right = mid;
			} else {
				left = mid;
			}
			mid = (left + right) / 2;
			loop1++;
			;
		} while (Math.abs(mid * mid - number1) >= deviation);
		System.out.println("Squared root of " + number1 + " = " + mid);
		System.out.println("Loop count = " + loop1);

		// SEQUENTIAL SEARCH - Prone to infinite looping

		System.out.println();
		System.out.println("SEQUENTIAL SEARCH");
		double number2 = 36;
		double search = 0;
		double incremental = 0.01;
		int loop2 = 0;
		if (number2 <= 0) {
			System.out.println("The number must be positive.");
			return;
		}
		while (Math.abs(search * search - number2) >= deviation) {
			search = search + incremental;
			loop2++;
		}
		System.out.println("Square root of " + number2 + " is: " + search);
		System.out.println("Loop count = " + loop2);

		// FUNCTIONS

		System.out.println();
		int a = 5;
		int b = 10;
		int[] arr = { 5, 10 };
		System.out.println(arr); // This arr in main refers to a different address in Heap to arr in be08Max_4. [[I@5d099f62
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);

		// arr[0] = 5
		// arr[1] = 10
		// This is because the program has not run be08Max_3 yet, which changes them to 50 and 100, respectively.

		int c = Math.max(a, b);
		int d = be08Max(a, b);
		int e = be08Max_2(a, b);
		int f = be08Max_3(a, b, arr);
		int g = be08Max_4(a, b, arr);
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("arr[0] = " + arr[0]);
		System.out.println("arr[1] = " + arr[1]);

		// arr[0] = 50
		// arr[1] = 100
		// be08Max_3 has been run. Both arr in main and be08Max_3 refer to the same address in Heap.
		// This means while arr in be08Max_3 is terminated, the address is still referenced by arr in main. Thus changes are kept.
		// While a and b in be08Max_3 are terminated by garbage collector.

		System.out.println("Math.max(" + a + ", " + b + ") = " + c);
		System.out.println("be08Max(" + a + ", " + b + ") = " + d);
		System.out.println("be08Max_2(" + a + ", " + b + ") = " + e);
		System.out.println("be08Max_3(" + arr[0] + ", " + arr[1] + ") = " + f);
		System.out.println("be08Max_3(" + arr[0] + ", " + arr[1] + ") = " + g);
	}

	// be08Max : function name.
	// int num1, int num2 : 2 parameters of the function and their data types.
	// public static int : data type of returned value.

	public static int be08Max(int num1, int num2) {
		if (num1 > num2) {
			return num1;
		}
		return num2;
	}

	public static int be08Max_2(int a, int b) {
		a = 50;
		b = 100;
		if (a >= b) {
			return a;
		}
		return b;
	}

	public static int be08Max_3(int a, int b, int[] arr) {
		a = 50;
		b = 100;
		arr[0] = 50;
		arr[1] = 100;
		if (a >= b) {
			return a;
		}
		return b;
	}

	public static int be08Max_4(int a, int b, int[] arr) {
		a = 50;
		b = 100;
		arr = new int[2];
		arr[0] = 50;
		arr[1] = 100;
		System.out.println(arr);
				
		// This arr in be08Max_4 refers to a different address in Heap to arr in main. [I@37f8bb67
		// This updates values in arr in be08Max_4 with arr[0] = 50 and rr[1] = 100. But arr in main remains the same.
		
		if (a >= b) {
			return a;
		}
		return b;
	}
}

		// Generally functions are utilised for data and logic set up. They are made for repeated usages, considered as tools to be applied whenever needed.
		// Check HW 6.1 and HW 6.2 for examples.
		// Extra: Rest paramenters?? (String... strings)