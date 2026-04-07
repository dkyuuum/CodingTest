import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int computer = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int connection = Integer.parseInt(st2.nextToken());
        
        ArrayList<Integer>[] graph = new ArrayList[computer+1];
        boolean[] visited = new boolean[computer+1];

        for (int i=1; i<=computer; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<connection; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st3.nextToken());
            int num2 = Integer.parseInt(st3.nextToken());

            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        dfs(visited, graph, 1);
        System.out.println(count);
    }

    public static void dfs(boolean[] visited, ArrayList<Integer>[] graph, int node) {
        visited[node] = true;

        for (int next: graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                count++;
                dfs(visited, graph, next);
            }
        }
    }
}
