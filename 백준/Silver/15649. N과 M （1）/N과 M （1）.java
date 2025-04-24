import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        permutation(arr, 0, 0, N, M);
    }

    public static void permutation(int[] arr, int flag, int depth, int n, int r) {
        if(depth == r) {
            for (int res : arr) {
                if (res != 0) {
                    System.out.print(res+ " ");
                }
            }
            System.out.println();
        } else {
            for (int i=1; i<=n; i++) {
                if ((flag & 1 << i) != 0) { continue; }
                arr[depth] = i;
                permutation(arr, flag|1 << i, depth+1, n, r);
            }
        }
    }
}