import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int count = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 가라앉지 않는 영역

        int[][] area = new int[N][N];
        int maxHeight = 0;
        int answer = 0;
        
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j=0; j<N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, area[i][j]);
            }
        }

        for (int h=0; h<maxHeight; h++) {
            boolean[][] visited = new boolean[N][N];
            count = 0;
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j] && area[i][j] > h) {
                        dfs(area, visited, i, j, N, h);
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    public static void dfs(int[][] area, boolean[][] visited, int x, int y, int N, int h) {
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0  && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && area[nx][ny] > h) {
                    dfs(area, visited, nx, ny, N, h);
                }
            }
        }
    }
}
