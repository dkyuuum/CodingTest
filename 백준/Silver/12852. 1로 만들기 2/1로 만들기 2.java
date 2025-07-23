import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];      // dp[i]: i를 1로 만드는데 필요한 최소 연산 횟수
        int[] prev = new int[n + 1];    // prev[i]: i에 오기 직전 숫자 저장

        dp[1] = 0; // 1은 연산 없이 1이므로 0번

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }

            if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        // 정답 출력
        System.out.println(dp[n]);

        // 경로 출력 (역추적)
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n).append(" ");
            n = prev[n];
        }

        System.out.println(sb);
    }
}
