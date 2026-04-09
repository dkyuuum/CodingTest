import java.io.*; 
import java.util.*; 

public class Main { 
    public static int[] dx = {-1, 0, 1, 0}; 
    public static int[] dy = {0, 1, 0, -1}; 
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int count = 0;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];
        for (int i=0; i<N; i++) { 
            st = new StringTokenizer(br.readLine(), " "); 
            for (int j=0; j<M; j++) { 
                graph[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        boolean[][] visited = new boolean[N][M];
        while (true) {
            // 1. 청소
            if (!visited[r][c]) {
                visited[r][c] = true;
                count++;
            }

            boolean moved = false;

            // 2. 4방향 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4; // 왼쪽 회전
                int nx = r + dx[d];
                int ny = c + dy[d];

                if (graph[nx][ny] == 0 && !visited[nx][ny]) {
                    r = nx;
                    c = ny;
                    moved = true;
                    break;
                }
            }

            // 3. 이동 못한 경우
            if (!moved) {
                int back = (d + 2) % 4;
                int nx = r + dx[back];
                int ny = c + dy[back];

                if (graph[nx][ny] == 1) break; // 종료
                else {
                    r = nx;
                    c = ny;
                }
            }
        }
        System.out.println(count);
    }
}
