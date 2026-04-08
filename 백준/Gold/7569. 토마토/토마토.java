import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1, -1, 0, 0, 0, 0};
    public static int[] dy = {0, 0, 1, -1, 0, 0};
    public static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        
        int[][][] tomato = new int[H][N][M];
        Queue<int[]> q = new LinkedList<>();
        
        for (int z=0; z<H; z++) {
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                for (int j=0; j<M; j++) {
                    tomato[z][i][j] = Integer.parseInt(st.nextToken());
                                        
                    if (tomato[z][i][j] == 1) {
                        q.add(new int[]{z, i, j});
                    }
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cz = cur[0];
            int cx = cur[1];
            int cy = cur[2];

            for (int t=0; t<6; t++) {
                int nx = cx + dx[t];
                int ny = cy + dy[t];
                int nz = cz + dz[t];

                if (nx >= 0 && ny >= 0 && nz >= 0 && nx < N && ny < M && nz < H) {
                    if (tomato[nz][nx][ny] == 0) {
                        tomato[nz][nx][ny] = tomato[cz][cx][cy] + 1;
                        q.add(new int[]{nz, nx, ny});
                    }
                }
            }
        }
        int max = 0;
        for (int z=0; z<H; z++) {
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    if (tomato[z][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, tomato[z][i][j]);
                }
            }
        }
        System.out.println(max-1);
    }
}
