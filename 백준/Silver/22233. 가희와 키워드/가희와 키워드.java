import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가희가 메모장에 적은 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 가희가 블로그에 쓴 글

        Set<String> keywords = new HashSet<>();
        for (int i=0; i<N; i++) {
            keywords.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder(); // 출력 최적화

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while (st.hasMoreTokens()) {
                String s = st.nextToken();
                keywords.remove(s);
            }
            sb.append(keywords.size()).append("\n");
        }
        System.out.print(sb);
    }
}