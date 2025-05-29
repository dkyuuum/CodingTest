import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 999;
        
        for (int i=0; i<wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int j=0; j<=n; j++) {
                graph.add(new ArrayList<>());
            }            
            
           for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번째 간선은 끊는다
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            
            int count = bfs(n, wires[i][0], graph);
            int diff = Math.abs(n - count - count);
            answer = Math.min(answer, diff);
        }
        return answer;
    }
    
    public int bfs(int n, int start, List<List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int count = 1;
        
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int q = queue.poll();
            
            for (int now: graph.get(q)) {
                if (!visited[now]) {
                    visited[now] = true;
                    queue.offer(now);
                    count++;
                }
            }
        }
        return count;
    }
}