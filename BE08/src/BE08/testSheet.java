package BE08;

import java.util.Scanner;

public class testSheet {

	// ArrayList

	public static void test01(String[] args) {
		int[] a = { 4, 8, 6, 7 };
		int resize = 3;

		int[] temp = new int[resize];
		int index = 0;

		for (int i = 0; i < resize; i++) {
			temp[index] = a[i];
			index++;
		}

		System.out.print("New size: ");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void test02(String[] args) {
		
		int choice = Scanner.nextInt();
	}
}