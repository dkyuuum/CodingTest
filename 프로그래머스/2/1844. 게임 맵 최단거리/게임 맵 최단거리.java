import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        return bfs(0, 0, 1, maps, visited);
    }
    
    public int bfs(int x, int y, int count, int[][] maps, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        int xLen = maps.length;
        int yLen = maps[0].length;
        queue.add(new int[]{x, y, count});
        visited[x][y] = true;
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int n = current[0];
            int m = current[1];
            int d = current[2];
            
            if (n == xLen-1 && m == yLen-1) {
                return d;
            }
            
            for (int i=0; i<4; i++) {
                int newX = dx[i] + n;
                int newY = dy[i] + m;

                if (newX >= 0 && newX < xLen && newY >= 0 && newY < yLen) {
                    if (!visited[newX][newY] && maps[newX][newY] == 1) {
                        queue.add(new int[]{newX, newY, d+1});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }
}