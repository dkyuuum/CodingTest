class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n+1];
        
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, visited, i);
            }
        }
        
        return answer;
    }
    
    public static void dfs(int[][] computers, boolean[] visited, int i) {
        visited[i] = true;
        
        for (int j=0; j<computers.length; j++) {
            if (!visited[j] && computers[i][j] == 1) { // 방문하지 않았고 값이 1이라면
                dfs(computers, visited, j);
            }
        }
    }
}