import java.io.*;
import java.util.*;

// 최소 칸의 수 구하기 -> bfs
public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][M];                // 미로 넣을 배열
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            
            for (int j=0; j<M; j++) {
                graph[i][j] = line.charAt(j) -'0';
            }
        }
        
        Queue<int[]> q = new LinkedList<>();            // bfs 할 Queue
        q.add(new int[]{0, 0});                         // 첫번째 좌표 넣기 
        graph[0][0] = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (graph[nx][ny] == 1) {
                        graph[nx][ny] = 0;                    // 방문 처리
                        graph[nx][ny] = graph[cx][cy] + 1;
                        q.add(new int[]{nx, ny});
                    } 
                }
            }
        }
        System.out.println(graph[N-1][M-1]);
    }
}
