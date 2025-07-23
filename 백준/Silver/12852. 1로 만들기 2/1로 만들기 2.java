import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
            }

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
            }
        }

        System.out.println(dp[N]);
        printPath(N);
    }

    // 재귀 함수로 경로 출력
    static void printPath(int x) {
        System.out.print(x + " ");
        if (x == 1) return;

        if (x % 3 == 0 && dp[x] == dp[x / 3] + 1) {
            printPath(x / 3);
        } else if (x % 2 == 0 && dp[x] == dp[x / 2] + 1) {
            printPath(x / 2);
        } else {
            printPath(x - 1);
        }
    }
}
