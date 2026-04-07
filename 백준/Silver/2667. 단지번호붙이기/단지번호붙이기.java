import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {1, -1,  0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] road = new int[N][N];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String line = br.readLine();

            for (int j=0; j<N; j++) {
                road[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (road[i][j] == 1) {      // 값이 1이라면
                    count = 1;               
                    dfs(i, j, N, road);     // dfs
                    result.add(count);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int i=0; i<result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static void dfs(int mx, int my, int N, int[][] road) {
        road[mx][my] = 0;               // 방문 처리

        for (int i=0; i<4; i++) {
            int nx = mx + dx[i];
            int ny = my + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (road[nx][ny] == 1) {
                    dfs(nx, ny, N, road);
                    count++;
                }
            }
        }
    }
 }
