import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        boolean[] visited = new boolean[n];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        permutation(arr, result, visited, 0, n, n);
    }

    // 사전순 정렬, n개 중 r개 뽑기
    public static void permutation(int[] arr, int[] result, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int res : result) {
                System.out.print(res + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) { // 아직 방문하지 않았다면
                visited[i] = true; // 방문 체크
                result[depth] = arr[i];
                permutation(arr, result, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

}