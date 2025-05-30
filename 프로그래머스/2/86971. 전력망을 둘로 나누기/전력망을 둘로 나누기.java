import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 999;
        
        for (int i=0; i<wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            
            for (int j=0; j<=n; j++) {
                graph.add(new ArrayList<>());
            }
            
            for (int j=0; j<wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            
            int count = bfs(n, wires[i][0], graph);
            int diff = Math.abs(n - count - count);
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }
    
    public int bfs(int n, int start, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        int count = 1;
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            
            for (int next: graph.get(cur)) {
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