import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                dfs(n, i, computers, visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dfs(int n, int k, int[][] computers, boolean[] visited) {
        visited[k] = true;
        
        for (int i=0; i<n; i++) {
            if (!visited[i] && computers[k][i] == 1) {
                dfs(n, i, computers, visited);
            }
        }
    }
}