import java.util.*;

class Solution {
    public static int sum = 0;

    public int solution(int[] numbers, int target) {
        return dfs(0, 0, numbers, target);
    }
    
    public int dfs(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
        if (sum == target) return 1;
            else return 0;
        }

        return dfs(depth+1, sum + numbers[depth], numbers, target)
             + dfs(depth+1, sum - numbers[depth], numbers, target);
    }
}