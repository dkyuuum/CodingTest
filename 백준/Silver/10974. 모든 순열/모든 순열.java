import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        permutation(arr, visited, 0, n);
//        permutationByBitMasking(arr);
    }

    // 사전순 정렬, n개 중 r개 뽑기
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
}