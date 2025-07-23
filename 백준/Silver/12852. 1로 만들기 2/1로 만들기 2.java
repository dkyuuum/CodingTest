import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];      // 연산 횟수
        int[] pd = new int[n + 1];    // 이전 숫자 기록

        
        for (int i=2; i<=n; i++) {
            // 1 뺄 때
            dp[i] = dp[i-1] + 1;
            pd[i] = i-1;

            // 2로 나누어질 때
            if (i%2 == 0 && dp[i/2]+1 < dp[i]) {
                dp[i] = dp[i/2] + 1;
                pd[i] = i/2;
            }

            // 3으로 나누어질 때
            if (i%3 == 0 && dp[i/3]+1 < dp[i]) {
                dp[i] = dp[i/3] + 1;
                pd[i] = i/3;
            }
        }
        System.out.println(dp[n]);

        StringBuilder sb = new StringBuilder();
        for (int i=n; i>0; i=pd[i]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
