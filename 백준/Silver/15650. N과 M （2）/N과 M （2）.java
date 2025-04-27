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

        combination(arr, 0, 1, 0, N, M);
    }

    public static void combination(int[] arr, int flag, int num, int depth, int n, int r) {
        if(depth == r) {
            for (int i=0; i<r; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        } else {
            for (int i=num; i<=n; i++) {
                if ((flag & (1 << i)) == 0) {
                    arr[depth] = i;
                    combination(arr, flag|(1 << i), i+1, depth+1, n, r);
                }
            }
        }
    }
}