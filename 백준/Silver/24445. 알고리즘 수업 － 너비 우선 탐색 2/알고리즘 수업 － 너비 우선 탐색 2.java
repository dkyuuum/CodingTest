import java.io.*;
import java.util.*;

public class Main {
    public static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];
        int[] order = new int[N+1];

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

        Queue<Integer> q = new LinkedList<>();

        visited[R] = true;      // 시작점 방문 처리
        q.add(R);
        order[R] = count++;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for (int next: graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    order[next] = count++;
                }
            }
        }

        for (int i=1; i<=N; i++) {
            System.out.println(order[i]);
        }
    }
}
