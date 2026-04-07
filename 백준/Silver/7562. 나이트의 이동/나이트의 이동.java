import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-2, -2, -1, -1, 2, 2, 1, 1};
    public static int[] dy = {1, -1, 2, -2, 1, -1, 2, -2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());                // tc 횟수
        for (int k=0; k<T; k++) {
            Queue<int[]> q = new LinkedList<>();

            int I = Integer.parseInt(br.readLine());            // 한 변의 길이

            int[][] dist = new int[I][I];
            boolean[][] visited = new boolean[I][I];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            q.add(new int[]{startX, startY});
            visited[startX][startY] = true;

            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int cx = cur[0];
                int cy = cur[1];

                if (targetX == cx && targetY == cy) {
                    System.out.println(dist[cx][cy]);
                    break;
                }
                for (int d=0; d<8; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];

                    if (nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
