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
                    map[i][j] = 1;                          // 전체 값 채우기
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
                    map[i][j] = 0;                          // 테두리 제외하고 내용 없애기
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{characterX*2, characterY*2, 0});    // 시작 위치 * 2 (좌표값 키우기)
        visited[characterX*2][characterY*2] = true;         // 시작 위치 방문 처리
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dist = cur[2];
                        
            for (int i=0; i<4; i++) {
                int mx = cx + dx[i];                        // 현재 x좌표 이동
                int my = cy + dy[i];                        // 현재 y좌표 이동
                
                if (map[mx][my] == 1 && !visited[mx][my]) { // 값이 1이고 방문하지 않은 경우 
                    visited[mx][my] = true;                 // 현재 위치 방문 처리
                    q.add(new int[]{mx, my, dist+1});       // 
                }
            }
            
            if (cx == itemX*2 && cy == itemY*2) {           // 현재 위치가 itemX, itemY와 같다면
                return dist / 2;                            // 거리 / 2 반환
            }
        }
        
        return answer;
    }
}