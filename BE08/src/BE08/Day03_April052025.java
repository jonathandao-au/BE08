//	camelCase > snakecase => imJonathan > im_jonathan
// JAVA is a strict data type => clear
// Readability for readers not writers. Don't assume.
// Knowing which data type to use

package BE08;

public class Day03_April052025 {
	public static void main(String[] args) {
		var number1 = 5;

		int number2 = 100;
// number1 = "abc"; is wrong. When you initialize a variable with var its data type is declared accordingly to its first value and unchanged.

		boolean result1 = (number1 > number2 || number1 > 3 && number2 < 100);
		boolean result2 = (number1 < number2 || number1 > 3 && number2 < 100);

// Determine priorities of conditions by utilizing cond1 || (cond2 && cond3)

		System.out.println(result1);
		System.out.println(result2);

		boolean vartboolean; // 0 and 1. False and true. 1 bit
		byte varbyte = 127; // -128 to 127. 1 byte
		short varshort = 32767; // -32768 to 32767. 2 byte
		int varint = 2000000000; // -2mil to 2mil. 4 byte
		long varlong; // -9quintil to 9quintil. 8 byte
		float varfloat = 1; // up to 6-7 digits of decimals.
		double vardouble = 0.123456789; // up to 15 digits of decimals.
		char varchar = 'A';
		char varchar2 = ' ';

// value of varchar2 cannot be ''.
// char varcharnull = null; does not exist.

		String varstring = "I dont know wtf is going on."; // string of characters.
		String varstringnull = null; // null meaning string variable cannot refer to a value in Heap.

// Primitive vs Reference Data Type.
// Primitive variables are fixed in size and their value are stored within the size limit in Stack. Does not have null.
// Reference variables are stored with their corresponding address to refer to their actual values in Heap. Their address is stored as hexadecimal with  8 characters, thus 16 bytes.
// Stack vs Heap memory.
// Garbage collector?
// When a program finished running, all variables will be released, freeing operating memory.
// Data types with the capitalised first letter is of reference type (Integer, Double, etc.).
// These should only be used for their functions and utilities.
// These data types come along with their utilities and functions, hence taking up more memory rather than a fixed amount like primitive types.
// Primitive data types are suitable for simple calculations.
// Reference data types are utilised alongside with their corresponding functions from the library.
// An array with a preset primitive data type will have fixed-size boxes to store it's corresponding data.
// An array with a preset reference data type will store addresses for it's data in boxes instead of actual values.
// Extra: HTML, CSS, Java Script
	}
}