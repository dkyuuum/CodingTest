import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.println(bfs(N, K));
    }
     public static int bfs(int start, int target) {
        int n = 100001;
        
        boolean[] visited = new boolean[n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int position = current[0];
            int time = current[1];

            if (position == target) {
                return time;
            }

            int[] nextPositions = {position - 1, position + 1, position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next < n && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, time + 1});
                }
            }
        }

        return -1;
    }
}