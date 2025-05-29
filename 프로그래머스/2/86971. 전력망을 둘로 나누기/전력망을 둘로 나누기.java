import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            // i번째 간선을 끊기
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번째 간선은 끊는다
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 연결된 한 네트워크의 송전탑 개수 구하기
            int count = bfs(graph, n, wires[i][0]); // 임의의 시작점
            int diff = Math.abs(n - count - count); // 두 네트워크 차이
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}