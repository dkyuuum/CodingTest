// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int[] memo = new int[cost.length+1];

//         Arrays.fill(memo, -1);
//        return dp(cost.length, cost, memo);
//     }

//     int dp(int n, int[] cost, int[] memo) {
//         if (n == 0 || n == 1) return 0;
//         if (memo[n] == -1) {
//             int first = dp(n-1, cost, memo)+cost[n-1];
//             int second = dp(n-2, cost, memo)+cost[n-2];
//             memo[n] = Math.min(first, second);
//         }
//         return memo[n];
//     }
// }



class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2; i<n+1; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2]);
        }   
        return dp[n];
    }
}