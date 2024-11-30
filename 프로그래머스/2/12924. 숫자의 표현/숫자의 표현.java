class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i=1; i<=n; i++) {
            if (calculate(i, n)) answer++;
        }
        
        return answer;
    }
    
    private boolean calculate(int i, int k) {
        int sum = 0;
        
        for (int j=i; j<=k; j++) {
            sum += j;
            
            if (sum == k) {
                return true;
            } else if (sum > k) {
                return false;
            }
        }
        return false;
    }
}