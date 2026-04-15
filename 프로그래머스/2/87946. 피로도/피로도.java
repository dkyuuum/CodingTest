import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        return dfs(k, 0, visited, dungeons);
    }
    
    public int dfs(int cur, int count, boolean[] visited, int[][] dungeons) {
        int max = count;
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && dungeons[i][0] <= cur) {             // 방문하지 않음 + 첫번째 값이 현재 값보다 작거나 같은 경우
                visited[i] = true;                                  // 방문 처리
                max = Math.max(max, dfs(cur - dungeons[i][1], count + 1, visited, dungeons));       
                visited[i] = false;
            }
        }
        
        return max;
    }
}