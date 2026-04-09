import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;

        public State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] road = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        int rx = 0, ry = 0, bx = 0, by = 0;
        Queue<State> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                road[i][j] = line.charAt(j);
                
                // 빨간 구슬
                if (road[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } 
                // 파란 구슬
                else if (road[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;
        
        while(!q.isEmpty()) {
            State cur = q.poll();
            if (cur.depth >= 10) {
                continue;
            }

            for (int i=0; i<4; i++) {
                // 빨, 파 구슬 이동
                int[] r = move(cur.rx, cur.ry, dx[i], dy[i], road);
                int[] b = move(cur.bx, cur.by, dx[i], dy[i], road);
                
                // 빨, 파 구슬 좌표
                int nrx = r[0], nry = r[1];
                int nbx = b[0], nby = b[1];

                // 종료 조건
                // 파란 구슬이 구멍에 들어간 경우 > 실패
                if (road[nbx][nby] == 'O') continue;
                
                // 빨간 구슬이 구멍에 들어간 경우 > 성공 및 횟수 출력
                if (road[nrx][nry] == 'O') {
                    System.out.println(cur.depth+1);
                    return;
                }
                
                // 구슬이 겹친 경우
                if (nrx == nbx && nry == nby) {
                    // 빨간 구슬의 y좌표가 파란 구슬의 y좌표보다 큰 경우
                    if (r[2] > b[2]) {
                        // 빨간 구슬의 좌표 이동
                        nrx -= dx[i];
                        nry -= dy[i];
                    } 
                    // 파란 구슬의 y좌표가 빨간 구슬의 y좌표보다 큰 경우
                    else {
                        nbx -= dx[i];
                        nby -= dy[i];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new State(nrx, nry, nbx, nby, cur.depth+1));
                }
            }
        }
        System.out.println(-1);
    }
    
    // 구슬 이동 함수
    public static int[] move(int x, int y, int dx, int dy, char[][] board) {
        int count = 0;
        
        // 벽과 구멍을 만나기 전까지 계속 이동
        while(board[x + dx][y + dy] != '#' && board[x][y] != 'O') {
            x += dx;
            y += dy;
            count++;
        }
        return new int[]{x, y, count};
    }
}
