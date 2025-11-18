import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        int[][] dp = new int[height][height];

        // DP 배열 초기화 (맨 아래 줄 그대로 복사)
        for (int i = 0; i < height; i++) {
            dp[height-1][i] = triangle[height-1][i];
        }

        // Bottom-Up 방식으로 위로 올라가면서 최댓값 계산
        for (int i = height - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }
}