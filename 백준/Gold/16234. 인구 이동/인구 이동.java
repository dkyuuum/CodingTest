import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N*N 크기의 땅
        int L = Integer.parseInt(st.nextToken()); // 인구 차이 L명 이상
        int R = Integer.parseInt(st.nextToken()); // R명 이하

        int[][] A = new int[N][N]; // 땅 배열
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int days = 0;

        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(N, L, R, i, j, A, visited)) {
                            moved = true;
                        }
                    }
                }
            }
            if (!moved) break;
            days++;
        }
        System.out.println(days);

    }

    public static boolean bfs(int N, int L, int R, int x, int y, int[][] A, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>(); // 연합 국가

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        queue.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = A[x][y]; // 연합 인구수

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int curX = current[0];
            int curY = current[1];

            for (int d = 0; d < 4; d++) {
                int newX = curX + dx[d];
                int newY = curY + dy[d];

                if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
                    int diff = Math.abs(A[curX][curY] - A[newX][newY]);

                    // 인구수 차이가 L명 이상 R명 이하일 때
                    if (diff >= L && diff <= R && !visited[newX][newY]) {
                        queue.add(new int[]{newX, newY});
                        list.add(new int[]{newX, newY});

                        visited[newX][newY] = true;
                        sum += A[newX][newY];
                    }
                }
            }
        }
        if (list.size() == 1) return false;

        int avg = sum / list.size(); // 연합 인구수 평균
        for (int[] l : list) {
            A[l[0]][l[1]] = avg;
        }
        return true;
    }
}
