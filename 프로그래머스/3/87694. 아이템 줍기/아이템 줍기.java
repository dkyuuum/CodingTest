import java.util.*;

class Solution {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];        
        boolean[][] visited = new boolean[102][102];
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    map[i][j] = 1;
                }
            }
        }
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int i = x1 + 1; i < x2; i++) {
                for (int j = y1 + 1; j < y2; j++) {
                    map[i][j] = 0;
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
                        
            for (int i=0; i<4; i++) {
                int mx = cx + dx[i];
                int my = cy + dy[i];
                
                if (map[mx][my] == 1 && !visited[mx][my]) {
                    visited[mx][my] = true;
                    q.add(new int[]{mx, my, dist+1});
                }
            }
            
            if (cx == itemX*2 && cy == itemY*2) {
                return dist / 2;
            }
        }
        
        return answer;
    }
}