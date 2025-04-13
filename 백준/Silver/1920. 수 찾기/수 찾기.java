import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int j = 0; j < M; j++) {
            int target = sc.nextInt();
            if (binarySearch(A, target) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    // 이진 탐색
    private static int binarySearch(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;

        while (left <= right) {
            int mid = (right+left) / 2;

            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return -1;
    }
}