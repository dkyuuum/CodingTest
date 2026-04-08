import java.util.*;
import java.io.*;

public class Main{
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int u = Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());
            
            graph[u].add(v);
            graph[v].add(u);
        }
        for (int i=1; i<=N; i++) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N+1];
        dfs(graph, V, visited);
        System.out.println();
        visited = new boolean[N+1];
        bfs(graph, V, visited);
    }
    
    public static void dfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        
        for (int next: graph[start]) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }
    
    public static void bfs(ArrayList<Integer>[] graph, int start, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

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