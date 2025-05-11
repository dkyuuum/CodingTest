import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] date = new int[N+1];
        int[] money = new int[N+1];
        int[] dp = new int[N+2];

        for (int i=1; i<=N; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
            date[i] = Integer.parseInt(st.nextToken());
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            // i일까지의 최대 수익을 다음 날로 전달
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 상담 기간이 남아있는 퇴사 날짜보다 길다면
            if (date[i]+i > N+1) {
                continue;
            } else {
                dp[i + date[i]] = Math.max(dp[i + date[i]], dp[i] + money[i]);
            }
//            if (date[i]+i <= N) {
//                // 상담 가능
//            }
/*            if (date[i] + i > N) {
                dp[i] = dp[i+1];
            } else {
                // 상담 가능
                dp[i] = Math.max(money[i] + dp[i+date[i]], dp[i+1]);
            }*/
        }
        System.out.println(Math.max(dp[N], dp[N + 1]));
    }
}