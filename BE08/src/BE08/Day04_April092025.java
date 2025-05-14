package BE08;

public class Day04_April092025 {
	public static void main(String[] args) {

		// IF-ELSE vs SWITCH CASE

		char grade = 'A';

		switch (grade) {
		case 'A': {
			System.out.println("Student is Excellent.");
		}
		case 'B': {
			System.out.println("Student is Good.");
		}
		case 'C': {
			System.out.println("Student is Average.");
		}
		case 'D': {
			System.out.println("Student is Bad.");
		}
		}
		System.out.println();

		switch (grade) {
		case 'A': {
			System.out.println("Student is Excellent.");
			break;
		}
		case 'B': {
			System.out.println("Student is Good.");
			break;
		}
		case 'C': {
			System.out.println("Student is Average.");
			break;
		}
		case 'D': {
			System.out.println("Student is Bad.");
			break;
		}
		}
		System.out.println();

		// Switch case is different from if - else.
		// If - else runs continuously and check through conditions steps by steps. It's
		// condition and execution can be modified with whole code body. ?? || >= <= etc.
		// Switch case can only check through exact conditions, functioning like a list sorting function. Only ==.
		// Switch case simplifies conditions, based on only 1 variable, emphasizing better readability. You can see right away what is the conditions and determinants.
		// Switch case is preferable for simple models. Lists, grading, etc.
		// Notes: Switch case needs break;

		// ARRAY

		int[] arrInt = new int[3];
		
		// Array of ints, size = 3 holding 3 values. Size is fixed. Boxes size is fixed for their data type.
		// An array with a preset primitive data type will have fixed-size boxes to store it's corresponding data.
		// An array with a preset reference data type will store addresses for it's data in boxes instead of actual values.
		// This is because data size for reference type is controllable + corresponding functions and utilities.
		// Workaround by cloning values to a different array with reduced size.
		// [0][0][0]
		// index 0 => value = 0
		// index 1 => value = 0
		// index 2 => value = 0

		int number0 = arrInt[0];
		int number1 = arrInt[1];
		int number2 = arrInt[2];
		System.out.println(number0);
		System.out.println(number1);
		System.out.println(number2);
		System.out.println();

		arrInt[0] = 2;

		// [2][0][0]

		arrInt[1] = 4;

		// [2][4][0]

		arrInt[2] = 7;

		// [2][4][7]

		System.out.println("Length: " + arrInt.length);
		System.out.println(arrInt[0]);
		System.out.println(arrInt[1]);
		System.out.println(arrInt[2]);
		System.out.println();

		// OR

		int[] arrInt2 = { 2, 4, 7 };
		System.out.println("Length: " + arrInt2.length);
		int index2 = 0;
		System.out.println(arrInt2[index2]);
		index2 = index2 + 1;
		System.out.println(arrInt2[index2]);
		index2 = index2 + 1;
		System.out.println(arrInt2[index2]);
		index2 = index2 + 1;
		System.out.println();

		// OR
		// LOOP

		int[] arrInt3 = { 2, 4, 7 };
		System.out.println("Length: " + arrInt3.length);
		int index3 = 0;
		while (index3 < arrInt3.length) {
			System.out.println(arrInt3[index3]);
			index3 = index3 + 1;
		}

		// Default value of data types

		boolean[] arrayboolean = new boolean[1];
		byte[] arraybyte = new byte[1];
		short[] arrayshort = new short[1];
		int[] arrayint = new int[1];
		long[] arraylong = new long[1];
		float[] arrayfloat = new float[1];
		double[] arraydouble = new double[1];
		char[] arraychar = new char[1];
		String[] arraystring = new String[1];

		System.out.println("Boolean: " + arrayboolean[0]);
		System.out.println("Byte: " + arraybyte[0]);
		System.out.println("Short: " + arrayshort[0]);
		System.out.println("Int :" + arrayint[0]);
		System.out.println("Long: " + arraylong[0]);
		System.out.println("Float: " + arrayfloat[0]);
		System.out.println("Double: " + arraydouble[0]);
		System.out.println("Char: " + arraychar[0]);
		System.out.println("String: " + arraystring[0]);
		System.out.println();

		// String1 = null - reference does not have a value. "I don't know what the value is, or it hasn't been set yet."
		// String2 = "" => length = 0. "I do know the value — it's nothing, but on purpose."
		// String3 = " " => length = 1. "There's technically a character here, but it’s invisible."
		// Note: "" does not equal to /u0000 unicode. /u0000 = null in a naming context only. Null in string has no value.

		String string1 = null;
		String string2 = "";
		String string3 = " ";

		// System.out.println(string1.length()); This does not make sense.
		// String1 does not refer to anything, thus does not have a length to print. Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "string1" is null
		
		System.out.println(string2.length());
		System.out.println(string3.length());
		System.out.println();

	}
}