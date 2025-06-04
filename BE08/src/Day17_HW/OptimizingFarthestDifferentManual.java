package Day17_HW;

import java.util.Scanner;

public class OptimizingFarthestDifferentManual {

    public static int findMaxDistance(int[] A) {
        int n = A.length;
        int maxDistance = 0;

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (A[i] != A[j]) {
                    maxDistance = Math.max(maxDistance, j - i);
                    break;
                }
            }
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array length:");
        int n = scanner.nextInt();
        int[] A = new int[n];

        System.out.print("Enter array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int result = findMaxDistance(A);
        System.out.println("Maximum distance with different elements: " + result);
    }
}