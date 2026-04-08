import java.io.*;
import java.util.*;

// 모든 경우의 수 -> dfs
public class Main {
    public static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int computer = Integer.parseInt(br.readLine());            // 컴퓨터의 수
        int connection = Integer.parseInt(br.readLine());          // 컴퓨터 쌍의 수
        
        ArrayList<Integer>[] graph = new ArrayList[computer+1];    // 그래프 초기화
        for (int i=1; i<=computer; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<connection; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            graph[n].add(m);
            graph[m].add(n);
        }
        
        boolean[] visited = new boolean[computer+1];
        visited[1] = true;
        
        dfs(graph, visited, 1);
        System.out.println(count);
    }
    
    public static void dfs(ArrayList<Integer>[] graph, boolean[] visited, int node) {
        visited[node] = true;
        
        for (int next: graph[node]) {
            if (!visited[next]) {
                dfs(graph, visited, next);
                count++;
            }
        }
    }
}