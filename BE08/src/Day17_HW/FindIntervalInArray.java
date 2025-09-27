package Day17_HW;

import java.util.Scanner;

public class FindIntervalInArrayManual {
	public static boolean containsAll(int[] A, int start, int end, int L, int R) {
        int rangeSize = R - L + 1;
        boolean[] found = new boolean[rangeSize];
        for (int i = start; i <= end; i++) {
            int val = A[i];
            if (val >= L && val <= R) {
                found[val - L] = true;
            }
        }
        for (boolean b : found) {
            if (!b) return false;
        }
        return true;
    }

    public static int solution(int[] A, int L, int R) {
        int N = A.length;
        int minLength = Integer.MAX_VALUE;

        for (int start = 0; start < N; start++) {
            for (int end = start; end < N; end++) {
                if (containsAll(A, start, end, L, R)) {
                    int length = end - start + 1;
                    if (length < minLength) {
                        minLength = length;
                    }
                    break;
                }
            }
        }
        
        return (minLength == Integer.MAX_VALUE) ? -1 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array length: ");
        int n = scanner.nextInt();
        int[] A = new int[n];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        System.out.print("Enter L: ");
        int L = scanner.nextInt();
        System.out.print("Enter R: ");
        int R = scanner.nextInt();

        int result = solution(A, L, R);
        System.out.println("Shortest fragment length: " + result);
    }
}
