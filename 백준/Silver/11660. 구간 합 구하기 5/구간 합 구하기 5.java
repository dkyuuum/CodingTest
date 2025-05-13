import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 표의 크기
        int M = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수

        int[][] num = new int[N + 1][N + 1]; // 숫자 담는 배열
        int[][] sum = new int[N + 1][N + 1]; // 값 미리 전부 더하기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + num[i][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            result = sum[endX][endY]
                    - sum[startX - 1][endY]
                    - sum[endX][startY - 1]
                    + sum[startX - 1][startY - 1];

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
