package Day17_HW;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindIntervalInArray {
	public static int solution(int[] A, int L, int R) {
        int requiredCount = R - L + 1;
        Map<Integer, Integer> windowCount = new HashMap<>();
        int matched = 0, left = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < A.length; right++) {
            int num = A[right];
            if (num >= L && num <= R) {
                windowCount.put(num, windowCount.getOrDefault(num, 0) + 1);
                if (windowCount.get(num) == 1) matched++;
            }

            while (matched == requiredCount) {
                minLen = Math.min(minLen, right - left + 1);
                int remove = A[left++];
                if (remove >= L && remove <= R) {
                    windowCount.put(remove, windowCount.get(remove) - 1);
                    if (windowCount.get(remove) == 0) matched--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
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