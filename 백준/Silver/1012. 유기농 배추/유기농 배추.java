import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int k=0; k<T; k++) {
            int count = 0;

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] direction = new int[N][M];
            // 배열 전체 0으로 채우기
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    direction[i][j] = 0;
                }
            }

            // 좌표 찍은 곳만 1로 바꾸기
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                direction[Y][X] = 1;
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (direction[i][j] == 1) {
                        dfs(i, j, direction, M, N);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y, int[][] direction, int M, int N) {
        // dfs 돌려서 값이 1인 경우: 0으로 변경 후 방문 처리
        direction[x][y] = 0;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (direction[nx][ny] == 1) {
                    dfs(nx, ny, direction, M, N);
                }
            }
        }
    }
}
