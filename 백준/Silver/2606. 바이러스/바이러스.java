import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수

        ArrayList<Integer>[] graph = new ArrayList[N+1]; // 정수 리스트를 담는 배열로 선언

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[N+1]; // 방문 노드 확인
        int count = 0;
        count = dfs(1, visited, graph, count);

        System.out.println(count - 1);
    }
    public static int dfs(int v, boolean[] visited, ArrayList<Integer>[] graph, int count) {
        visited[v] = true;
        count++;

        for (int i: graph[v]) {
            if (!visited[i]) { // 방문하지 않은 노드로
                count = dfs(i, visited, graph, count);
            }
        }

        return count;
    }

}