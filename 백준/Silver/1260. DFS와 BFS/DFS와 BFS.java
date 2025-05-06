import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

        boolean[] visited; // 방문 노드 확인

        ArrayList<Integer>[] graph = new ArrayList[N+1]; // 정수 리스트를 담는 배열로 선언
//         List<List<Integer>> graph = new ArrayList<>(); // 2차원 리스트로 선언

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            // 간선이 연결하는 두 정점의 번호 입력
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

//        Arrays.sort(graph);
        // 번호가 작은 것부터 방문하도록 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1]; // 방문 노드 확인
        dfs(V, visited, graph);

        System.out.println();

        visited = new boolean[N+1];
        bfs(V, visited, graph);
    }

    public static void dfs(int v, boolean[] visited, ArrayList<Integer>[] graph) {
        System.out.print(v + " ");
        visited[v] = true;

        for (int i: graph[v]) {
            if (!visited[i]) { // 방문하지 않은 노드로
                dfs(i, visited, graph);
            }
        }
    }


    public static void bfs(int v, boolean[] visited, ArrayList<Integer>[] graph) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(10000);
        deque.add(v);
        visited[v] = true;

        while (!deque.isEmpty()) {
            int node = deque.poll(); // 큐에 있는 값 가져오기
            System.out.print(node + " ");

            for (int i: graph[node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    deque.add(i);
                }
            }
        }
    }
}