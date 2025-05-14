import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] scores = new long[n+1];
        long[] dp = new long[n+1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];
        if (n == 1) { // 계단 한 개
            System.out.println(dp[1]);
            return;
        }

        dp[2] = scores[1] + scores[2];
//        dp[3] = Math.max(scores[1] + scores[3], scores[2] + scores[3]);
        if (n == 2) { // 계단 두 개
            System.out.println(dp[2]);
            return;
        } else {
            for (int i=3; i<=n; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i];
            }
        }
        System.out.println(dp[n]);
    }
}
