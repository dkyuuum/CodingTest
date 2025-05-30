import java.util.*;

class Solution {
    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        visited[0] = true;
        
        // 정보 배열, 엣지 배열, 방문 배열, 양, 늑대
        return dfs(info, edges, visited, 1, 0);
    }
    
    int dfs(int[] info, int[][] edges, boolean[] visited, int sheep, int wolf) {
        //✅ 만약 늑대가 양보다 크거나 같으면 빠져나온다.
        if (sheep <= wolf) return sheep;
        int maxSheep = sheep;
        
        //✅ 모든 edge를 확인한다.
        for (int[] edge : edges) {
            final int parent = edge[0];
            final int child = edge[1];
            //✅ 부모가 방문된 상태이고 자식이 아직 방문되지 않은 상태라면 방문한다.
            if (visited[parent] && !visited[child]) {
                //✅ 다음 노드를 방문표시한다.
                visited[child] = true;
                //✅ 다음 노드가 양이라면 sheep + 1을 한다.
                if (info[child] == 0) {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep + 1, wolf));
                //✅ 다음 노드가 늑대라면 wolf + 1을 한다.
                } else {
                    maxSheep = Math.max(maxSheep, dfs(info, edges, visited, sheep, wolf + 1));
                }
                //✅ 다음 노드를 방문표시 해제한다.
                visited[child] = false;
            }
        }
        
        return maxSheep;
    }
}