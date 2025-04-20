import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if (list.get(i) <= K) { // 돈의 단위가 K보다 같거나 작을 떄
                count += K / list.get(i); // K를 돈의 단위로 나눈 값만큼 카운팅
                K %= list.get(i); // 나머지를 K로 다시 저장
            }
        }
        System.out.println(count);
    }
}