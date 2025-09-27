//	April 05, 2025
package BE08;

public class Day03_April052025_HW {
	public static void main(String[] args) {

//	METHOD 1

		double number1 = 36;
		double min = 0;
		double max = number1;
		double search1 = 0;
		double deviation1 = 0.01;
		if (number1 < 0)
			System.out.println("The number must be positive.");
		if (number1 < 1)
			max = 1;
		for (int i = 0; i < 100; i = i + 1) {
			search1 = (min + max) / 2.0;
			double square = search1 * search1;
			if (Math.abs(square - number1) <= deviation1)
				break;
			if (square < number1)
				min = search1;
			else
				max = search1;
		}
		System.out.println("Square root of " + number1 + " is: " + search1);

//	METHOD 2

		double number2 = 36;
		double search2 = 0;
		double deviation2 = 0.01;
		if (number2 < 0)
			System.out.println("The number must be positive.");
		while (Math.abs(search2 * search2 - number2) > deviation2)
			search2 = search2 + 0.01;
		System.out.println("Square root of " + number2 + " is: " + search2);

//	METHOD 3

		double number3 = -12;
		double guess = number3 / 2.0;
		double deviation3 = 0.01;
		double search3;
		if (number3 < 0)
			System.out.println("The number must be positive.");
		while (true) {
			search3 = 0.5 * (guess + number3 / guess); // Newton's Formula???
			if (Math.abs(search3 - guess) < deviation3)
				break;
			guess = search3;
		}
		System.out.println("Square root of " + number3 + " is: " + search3);
		
		// It's best to use Binary Search for this.
//	METHOD 4
		
		double number4 = 36;
		double min4 = 0;
		double max4 = number1;
		double mid4 = ( min4 + max4 ) / 2;
		double search4 = 0;
		double deviation4 = 0.01;
		if (number1 < 0) {
			System.out.println("The number must be positive.");
		}
		while (Math.abs(search4*search4 - number4) >= deviation4) {
				
		}
		
		while (min4 <= max4) {
			if (search4 < max4) {
				max4 = mid4 - deviation4;
			} else if (search4 > min4) {
				min4 = mid4 + deviation4;
			} else if (search4 == mid4) {
				System.out.println(mid4);
				break;
			}
		} 
	}
}