import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] board = new int[101];
        for (int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board[u] = v;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[101];
        int[] dist = new int[101];

        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if (cur == 100) {
                System.out.println(dist[cur]);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = cur + dice;

                if (next > 100) continue;
                if (board[next] != 0) {
                    next = board[next];         // 사다리 또는 뱀
                }

                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1; 
                    q.add(next);
                }
            }
        }
    }
}
