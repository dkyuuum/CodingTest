import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /***
         * 1. 주식 하나를 산다.
         * 2. 원하는 만큼 가지고 있는 주식을 판다.
         * 3. 아무것도 안한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // tc

        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine()); // 날의 수

            int[] price = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            long count = 0;
            long max = 0;
            for (int j=N-1; j>=0; j--) {
                if (price[j] > max) {
                    max = price[j];
                } else {
                    count += max -price[j];
                }
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}