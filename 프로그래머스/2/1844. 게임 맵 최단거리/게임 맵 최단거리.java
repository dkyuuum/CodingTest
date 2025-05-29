import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        answer = bfs(0, 0, maps, visited);
        
        return answer;
    }
    
    public int bfs(int x, int y, int[][] maps, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>(10000);
        queue.add(new int[]{0, 0, 1});
        visited[x][y] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int xLen = maps.length;
        int yLen = maps[0].length;
        
        while(!queue.isEmpty()) {
            int[] current = queue.remove();
            int r = current[0];
            int c = current[1];
            int d = current[2];

            if (r == xLen - 1 && c == yLen -1) {
                return d;
            }
            
            for (int i=0; i<4; i++) {
                int newX = dx[i] + r;
                int newY = dy[i] + c;

                if (newX >= 0 && newX < xLen && newY >= 0 && newY < yLen) {
                     if (!visited[newX][newY] && maps[newX][newY] == 1) {
                        queue.offer(new int[]{newX, newY, d+1});
                        visited[newX][newY] = true;
                     }
                }
            }
        }
        return -1;
    }
}