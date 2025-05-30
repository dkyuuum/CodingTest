import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int xLen = maps.length;
        int yLen = maps[0].length;
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        boolean[][] visited = new boolean[xLen][yLen];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0]; int c = cur[1]; int d = cur[2];
            
            if (r == xLen-1 && c == yLen-1) return d;
            
            for (int i=0; i<4; i++) {
                int newX = dx[i] + r;
                int newY = dy[i] + c;
                
                if (newX >= 0 && newX < xLen && newY >= 0 && newY < yLen) {
                    if (!visited[newX][newY] && maps[newX][newY] == 1) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY, d+1});
                    }
                }
            }
        }        
        return -1;
    }
}