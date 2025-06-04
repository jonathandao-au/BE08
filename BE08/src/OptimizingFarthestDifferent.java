package Day17_HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptimizingFarthestDifferent {
	public static int solution(int[] A) {
        int N = A.length;
        Map<Integer, Integer> firstOccurrence = new HashMap<>();
        int maxDistance = 0;

        for (int i = 0; i < N; i++) {
            firstOccurrence.putIfAbsent(A[i], i);
        }

        for (int j = 0; j < N; j++) {
            for (Map.Entry<Integer, Integer> entry : firstOccurrence.entrySet()) {
                int val = entry.getKey();
                int i = entry.getValue();
                if (A[j] != val) {
                    maxDistance = Math.max(maxDistance, Math.abs(j - i));
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

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int result = solution(A);
        System.out.println("Maximum distance with different elements: " + result);
    }
}

