//	April 02, 2025

// Declare 2 integers A and B
// Print the total number of whole squares within the interval [A:B]
// Example A = 4 , B = 17 -> result should be 3 because there are three squares of integers is : 4 = 2^2 | 9 = 3^2 | 16 = 4^2

// PLEASE RESEARCH LOOP (WHILE LOOP, FOR LOOP, etc)
package BE08;

public class Day02_April_02_2025_HW_Revised {
	public static void main(String[] args) {

//	Method 1	

		int a1 = 4052;
		int b1 = 5922;
		int i1 = 0;
		int count1 = 0;
		System.out.println("Range: [" + a1 + " - " + b1 + "]");
		while (i1 * i1 < a1)
			i1 = i1 + 1;
		while (i1 * i1 <= b1) {
			System.out.println(i1 * i1);
			i1 = i1 + 1;
			count1 = count1 + 1;
		}
		System.out.println(count1 + " whole square(s)");
		System.out.println();

// Method 2

		int a2 = 3;
		int b2 = 300;
		int i2 = (int) Math.ceil(Math.sqrt(a2));
		;
		int count2 = 0;
		System.out.println("Range: [" + a2 + " - " + b2 + "]");
		while (i2 * i2 <= b2) {
			System.out.println(i2 * i2);
			count2 = count2 + 1;
			i2 = i2 + 1;
		}
		System.out.println(count2 + " whole square(s)");

// Method 3

		int a3 = 542;
		int b3 = 967;
		int start = (int) Math.ceil(Math.sqrt(a3));
		int end = (int) Math.floor(Math.sqrt(b3));
		int count3 = Math.max(0, end - start + 1);
		System.out.println("Range: [" + a3 + " - " + b3 + "]");
		System.out.println(count3 + " whole square(s)");
	}
}