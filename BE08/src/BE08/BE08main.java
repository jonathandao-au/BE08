// March 29, 2025
package BE08;
public class BE08main {
	public static void main(String[] args) {
		System.out.println("Hello BE08");
		System.out.print("\n");
		System.out.println("I'm Jonathan");
		System.out.println("\n");// This makes 2 lines
			
			// Notes:
			// System = Application; out = output; print = function;
			// print = print out parameter; println = print out parameter THEN terminate the line
			// Eg. print("\n"); = println();
			
		int x = 5; // init
		System.out.println("x1 = " + x);
		x = 3; // assign a different value
		System.out.println("x2 = " + x);
		System.out.println();
		
			// Variables = carry a value to represent a meaning
			// Declare a variable = without a value = int length;
			// Initialize a variable = with a data type and assign value = int length = 5;
			// Variables only need to be initialized a data type ONCE
			// [int x = 5;] = [int x; x = 5;]
			// Variable priority = meaning > data type > value
			// Naming convention and IDE Eclipse (Ctrl + Space and suggestions)
			// Utilize // comments only when needed, keep it concise and efficient
			// Eg. rectangle length is an integer variable that cannot contain decimals => int length = 5;
			// and rectangle width is a real variable that contains one decimal => double width = 2.5;
			// Extra: Compiled vs interpreted language? Immutable variable (SPRING)? Primitive? Parameter => Preference?
		
		int length = 5;
		double width = 2.5;
		double perimeter = (length + width)*2;
		double area = length * width;
		System.out.println("Length = " + length);
		System.out.println("Width = " + width);
		System.out.println("Rectangle Perimeter = " + perimeter);
		System.out.println("Rectangle Area = " + area);
		System.out.println();

	}
}
