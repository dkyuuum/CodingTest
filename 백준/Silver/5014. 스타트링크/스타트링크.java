import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int F = Integer.parseInt(st.nextToken());   // 건물 층수
        int S = Integer.parseInt(st.nextToken());   // 강호가 지금 있는 층
        int G = Integer.parseInt(st.nextToken());   // 스타트링크가 있는 층
        int U = Integer.parseInt(st.nextToken());   // 위로
        int D = Integer.parseInt(st.nextToken());   // 아래로

        boolean[] visited = new boolean[F+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int floor = cur[0];
            int count = cur[1];

            int[] move = {floor + U, floor - D};

            // 강호가 지금 있는 층 == 스타트링크가 있는 층
            if (floor == G) {       
                System.out.println(count);
                return;
            }

            for (int next: move) {
                if (next >= 1 && next <= F && !visited[next]) {
                    visited[next] = true;
                    q.add(new int[]{next, count+1});
                }
            }
        }
        System.out.println("use the stairs");
    }

}
