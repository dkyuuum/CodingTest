import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

/*
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1; dp[1] + dp[0]
        dp[3] = 1; dp[2] + dp[1]
        dp[4] = 2; dp[3] + dp[2]
        dp[5] = 5-1 = 4;
        dp[6] = 1;
        dp[7] = 7-1;
        dp[8] = 4;
        dp[9] = 3;
        */

        for (int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + 1;

            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i/3]+1);
            }

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i/2]+1);
            }
        }
        System.out.println(dp[n]);
    }

}