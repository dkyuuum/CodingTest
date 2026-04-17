import java.util.*;

class Solution {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy= {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length)
                    continue;
                
                if ( maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[cx][cy] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        int answer = maps[maps.length - 1][maps[0].length - 1];
        return answer == 1 ? -1 : answer;
    }
}