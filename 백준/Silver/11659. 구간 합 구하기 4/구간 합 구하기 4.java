import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야하는 횟수

        int[] num = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int[] start = new int[N+1];
        int[] end = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[N+1];
        sum[0] = 0;
        for (int i=1; i<=N; i++) {
            sum[i] = sum[i-1] + num[i];
        }

        for (int i=1; i<=M; i++) {
            int s = start[i-1];
            int e = end[i-1];

            System.out.println(sum[e]-sum[s-1]);
        }
    }
}