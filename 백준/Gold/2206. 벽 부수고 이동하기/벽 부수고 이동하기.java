import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][M];
        int[][][] dist = new int[N][M][2];
        for (int i=0; i<N; i++) {
            String line = br.readLine();

            for (int j=0; j<M; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int b = cur[2];

            if (cx == N-1 && cy == M-1) {
                System.out.println(dist[cx][cy][b] + 1);
                return;
            }
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (graph[nx][ny] == 0 && !visited[nx][ny][b]) {
                        visited[nx][ny][b] = true;
                        dist[nx][ny][b] = dist[cx][cy][b] + 1;
                        q.add(new int[]{nx, ny, b});
                    } 
                    
                    if (graph[nx][ny] == 1 && b == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        dist[nx][ny][1] = dist[cx][cy][0] + 1;
                        q.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
