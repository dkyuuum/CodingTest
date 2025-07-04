import java.util.*;

class Solution {
    HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int len = numbers.length();
        
        backTracking(numbers, "0", len, new boolean[len]);
        
        return set.size();
    }
    
    public void backTracking(String numbers, String make, int len, boolean[] visited) {
        int num = Integer.parseInt(make);
        if (isPrime(num)) set.add(num);
        
        for (int i=0; i<len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(numbers, make+numbers.charAt(i), len, visited);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        
        for (int i=2; i*i<=n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}