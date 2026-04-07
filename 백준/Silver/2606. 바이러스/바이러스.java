import java.io.*;
import java.util.*;

public class Main {
    public static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int computer = Integer.parseInt(br.readLine());             // 컴퓨터의 수
        int connection = Integer.parseInt(br.readLine());           // 연결된 컴퓨터 쌍의 수
        
        ArrayList<Integer>[] graph = new ArrayList[computer+1];     // 정수 리스트를 담는 배열로 선언
        boolean[] visited = new boolean[computer+1];

        for (int i=1; i<=computer; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<connection; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1].add(num2);
            graph[num2].add(num1);
        }

        dfs(visited, graph, 1);
        System.out.println(count);
    }

    public static void dfs(boolean[] visited, ArrayList<Integer>[] graph, int node) {
        visited[node] = true;               // 방문 처리

        for (int next: graph[node]) {
            if (!visited[next]) {           // 방문하지 않은 노드의 경우
                count++;
                dfs(visited, graph, next);
            }
        }
    }
}
