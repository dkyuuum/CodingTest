import java.util.*;
import java.io.*;

public class Main {
    public static int count = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N+1];
        int[] order = new int[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }
        dfs(graph, visited, order, R);

        for (int i=1; i<=N; i++) {
            System.out.println(order[i]);
        }
    }

    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int[] order, int node) {
        visited[node] = true;
        order[node] = count++;

        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(graph, visited, order, next);
            }
        }
    }
}
