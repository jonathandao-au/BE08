package Day16_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SameDiceSum {
	public static int minDiceTurns(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();

        if (sumA > sumB) {
            return minDiceTurns(B, A);
        }

        int diff = sumB - sumA;
        if (diff == 0) return 0;

        List<Integer> gains = new ArrayList<>();

        for (int a : A) {
            gains.add(6 - a);
        }
        for (int b : B) {
            gains.add(b - 1);
        }

        gains.sort(Collections.reverseOrder());

        int steps = 0;
        for (int gain : gains) {
            diff -= gain;
            steps++;
            if (diff <= 0) {
                return steps;
            }
        }

        return -1;
    }

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of dice in array A: ");
        int n = scanner.nextInt();
    	scanner.nextLine();
        int[] A = new int[n];
        System.out.println("Enter values for A: ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        
        System.out.println();
        
        System.out.print("Enter number of dice in array B: ");
        int m = scanner.nextInt();
        int[] B = new int[m];
        System.out.println("Enter values for B: ");
        for (int i = 0; i < m; i++) {
            B[i] = scanner.nextInt();
        }

        System.out.println();
        int result = minDiceTurns(A, B);
        System.out.println("Minimum number of dice to turn: " + result);
    }
}
