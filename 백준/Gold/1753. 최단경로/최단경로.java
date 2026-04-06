import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer((reader.readLine()));

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer((reader.readLine()));
        int K = Integer.parseInt(st2.nextToken());

        ArrayList<int[]>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            StringTokenizer st3 = new StringTokenizer((reader.readLine()));
            int u = Integer.parseInt(st3.nextToken());
            int v = Integer.parseInt(st3.nextToken());
            int w = Integer.parseInt(st3.nextToken());

            graph[u].add(new int[]{v, w});
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[K] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        q.add(new int[]{K, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int cost = cur[1];

            if (dist[now] < cost) continue;

            for (int[] next : graph[now]) {
                int nextNode = next[0];
                int nextCost = cost + next[1];

                if (dist[nextNode] > nextCost) {
                    dist[nextNode] = nextCost;
                    q.add(new int[]{nextNode, nextCost});
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
