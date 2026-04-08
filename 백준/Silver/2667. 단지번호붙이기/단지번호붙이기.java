import java.io.*;
import java.util.*;

// 덩어리 갯수 구하기 -> dfs
public class Main {
    public static int[] dx = {1, -1,  0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] graph = new int[N][N];
        ArrayList<Integer> dist = new ArrayList<>();
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            
            for (int j=0; j<N; j++) {
                graph[i][j] = line.charAt(j) - '0';        
            }
        }
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (graph[i][j] == 1) {
                    count = 1;
                    dfs(graph, i, j, N);
                    dist.add(count);
                }
            }
        }

        Collections.sort(dist);
        System.out.println(dist.size());
        for (int next: dist) {
            System.out.println(next);
        }
    }

    public static void dfs(int[][] graph, int cx, int cy, int N) {
        graph[cx][cy] = 0;

        for (int i=0; i<4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (graph[nx][ny] == 1) {
                    dfs(graph, nx, ny, N);
                    count++;
                }
            }
        }
    }
}