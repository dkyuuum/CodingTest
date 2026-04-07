import java.util.*;
import java.io.*;

public class Main {
    public static boolean[] visited;
    public static int[] order;
    public static int count = 1;
    public static ArrayList<Integer>[] graph;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];

        graph = new ArrayList[N+1];
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
            Collections.sort(graph[i]);
        }
        
        dfs(R);

        for (int i=1; i<=N; i++) {
            System.out.println(order[i]);
        }
    }

    public static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;

        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
