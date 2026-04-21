class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        int[][] danger = new int[n][n];
        
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        // 1 기준으로 위험지역 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    danger[i][j] = 1;
                    
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                            danger[nx][ny] = 1;
                        }
                    }
                }
            }
        }
        
        // 안전지대 개수 세기
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (danger[i][j] == 0) count++;
            }
        }
        
        return count;
    }
}