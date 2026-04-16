// class Solution {
//     public int solution(int[][] triangle) {
//         int n = triangle.length;
//         int[] dp = new int[n];
        
//         dp[0] = triangle[0][0];
        
//         for (int i = 1; i < n; i++) {
//             // 뒤에서부터 갱신
//             for (int j = i; j >= 0; j--) {
//                 if (j == 0) {
//                     dp[j] = dp[j] + triangle[i][j];
//                 } else if (j == i) {
//                     dp[j] = dp[j-1] + triangle[i][j];
//                 } else {
//                     dp[j] = Math.max(dp[j-1], dp[j]) + triangle[i][j];
//                 }
//             }
//         }
        
//         int answer = 0;
//         for (int num : dp) {
//             answer = Math.max(answer, num);
//         }
        
//         return answer;
//     }
// }

class Solution {
    public int solution(int[][] triangle) {
        int n = triangle.length;
        int[][] dp = new int[n][n];
        
        // 초기값
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            // 맨 왼쪽
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            
            // 가운데
            for (int j = 1; j < i; j++) {
                dp[i][j] = triangle[i][j] 
                         + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
            
            // 맨 오른쪽
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];
        }
        
        // 마지막 줄에서 최대값 찾기
        int answer = 0;
        for (int j = 0; j < n; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        return answer;
    }
}