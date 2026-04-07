import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited;

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        /**
         * dfs
         */
        visited = new boolean[N+1];
        dfs(visited, graph, V);

        System.out.println();
        /**
         * bfs
         */
        visited = new boolean[N+1];
        bfs(visited, graph, V);
    }

    public static void dfs(boolean[] visited, ArrayList<Integer>[] graph, int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(visited, graph, next);
            }
        }
    }

    public static void bfs(boolean[] visited, ArrayList<Integer>[] graph, int node) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print(cur + " ");

            for (int next: graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
