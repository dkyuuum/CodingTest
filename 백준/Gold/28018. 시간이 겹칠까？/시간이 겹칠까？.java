import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] seat = new int[1000002]; // 자리 수

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 댓글 달아준 학생 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()); // 좌석 배정 시각
            int end = Integer.parseInt(st.nextToken()); // 종료 시각

            seat[start]++;
            seat[end+1]--;
        }

        for (int i = 1; i < seat.length; i++) {
            seat[i] += seat[i - 1];
        }

        int q = Integer.parseInt(br.readLine()); // 특정한 시각의 개수
        st = new StringTokenizer(br.readLine());
        int[] times = new int[q];
        for (int i = 0; i < q; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(seat[times[i]]).append("\n");
        }
        System.out.println(sb);
    }
}
