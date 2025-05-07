import java.util.*;

public class Solution{
//    public static void main(String[] args) {
//        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
//        System.out.println(solution(6, edge));
//    }

    public static int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        int answer = 0;

        // 초기화
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n+1];
        int[] distance = new int[n+1];
        bfs(graph, visited, distance);

        int max = -999;
        for (int d : distance) {
            if (d > max) {
                max = d;
                answer = 1;
            } else if (d == max) {
                answer++;
            }
        }

        return answer;
    }

    public static void bfs(List<List<Integer>> graph, boolean[] visited, int[] distance) {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        d.add(1);
        visited[1] = true;

        while (!d.isEmpty()) {
            int next = d.poll();
            for (int n : graph.get(next)) {
                if (!visited[n]) {
                    visited[n] = true;
                    distance[n] = distance[next] + 1;
                    d.add(n);
                }
            }
        }
    }
}