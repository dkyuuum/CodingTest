import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 구멍 갯수
        int m = Integer.parseInt(st.nextToken()); // 햄스터 부피

        int[] width = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            width[i] = Integer.parseInt(st.nextToken()); // 각 구멍 크기
        }

        int left = 0, right = 0;
        int sum = 0;
        int max = 0;

        while (right < n) {
            sum += width[right];

            while (sum > m && left <= right) {
                sum -= width[left++];
            }

            // 조건을 만족하면 최댓값 갱신
            max = Math.max(max, sum);

            right++;
        }

        System.out.println(max);
    }
}
