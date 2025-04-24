import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

//        permutation(arr, visited, 0, n);
        permutationByBitMasking(arr, 0, 0, n);
    }

    // 순열 n개 중 r개 뽑기 - visited 사용
    public static void permutation(int[] arr, boolean[] visited, int depth, int n) {
        if (depth == n) {
            for (int res : arr) {
                System.out.print(res + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) { // 아직 방문하지 않았다면
                visited[i] = true;
                arr[depth] = i+1;
                permutation(arr, visited, depth+1, n);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 순열 n개 중 r개 뽑기 - bit masking 사용

    /**
     * 비트마스킹을 사용한 순열
     * @param arr 수 배열
     * @param flag 비트 마스킹 변수
     * @param depth 깊이
     * @param n n개 중 n개 뽑기 (n!)
     */
    public static void permutationByBitMasking(int[] arr, int flag, int depth, int n) {
        if (depth == n) {
            for (int res : arr) {
                System.out.print(res + " ");
            }
            System.out.println();
        } else {
            for (int i=0; i<n; i++) {
                if ((flag & 1 << i) != 0) { continue; }
                arr[depth] = i+1;
                permutationByBitMasking(arr, flag|1 << i, depth+1, n);
            }
        }
    }
}