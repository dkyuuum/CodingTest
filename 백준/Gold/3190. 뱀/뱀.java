import java.io.*;
import java.util.*;

public class Main {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 보드의 크기

        int[][] board = new int[N][N];

        // 사과의 개수
        int K = Integer.parseInt(br.readLine());    
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1; 
        }
        
        // 뱀의 방향 변환 정보
        Map<Integer, Character> direction = new HashMap<>();
        int L = Integer.parseInt(br.readLine());    
        for (int i=0; i<L; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            char y = st.nextToken().charAt(0);

            direction.put(x, y);
        }

        int time = 0;
        int d = 0;

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 2;            // 뱀의 몸통

        while(true) {
            time++;

            int[] head = snake.peekFirst();
            int hx = head[0] + dx[d];
            int hy = head[1] + dy[d];

            // 종료 조건
            if (hx < 0 || hy < 0 || hx >= N || hy >= N || board[hx][hy] == 2) {
                System.out.println(time);
                break;
            }

            if (board[hx][hy] == 1) {       // 사과인 경우
                board[hx][hy] = 2;          // 몸통으로 만들기
                snake.addFirst(new int[]{hx, hy});
            } else {
                board[hx][hy] = 2;          // 몸통으로 만들기
                snake.addFirst(new int[]{hx, hy});

                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            // D: direction을 오른쪽으로 90도
            // L: direction을 왼쪽으로 90도
            if (direction.containsKey(time)) {
                if (direction.get(time) == 'D') {
                    d = (d+1) % 4;
                } else {
                    d = (d+3) % 4;
                }
            }
        }

    }
}
