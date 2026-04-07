import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    public static int bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});

        boolean[] visited = new boolean[100001];
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0];
            int count = cur[1];

            if (node == target) {
                return count;
            }

            int[] next = {node-1, node+1, node*2};
            for (int n: next) {
                if (n>=0 && n<100001 && !visited[n]) {
                    visited[n] = true;
                    q.add(new int[]{n, count+1});
                }
            }        
        }
        return -1;
    }
}
