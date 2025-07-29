import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    // find 연산 (경로 압축)
    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // 경로 압축
        }
        return parent[x];
    }

    // union 연산
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;  // 한쪽 루트를 다른 쪽에 붙임
        }
    }

    public static void main(String[] args) throws IOException {
        // 빠른 입출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 0~n까지 집합
        int m = Integer.parseInt(st.nextToken()); // 연산 수

        // 부모 배열 초기화
        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        // 연산 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());
            int a  = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());

            if (op == 0) {
                union(a, b);
            } else { // op == 1
                if (find(a) == find(b)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        System.out.print(sb);
    }
}
