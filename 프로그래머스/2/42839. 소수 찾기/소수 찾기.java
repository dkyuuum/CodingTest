import java.util.*;

class Solution {
    public Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        int len = numbers.length();
        backtracking(numbers, len, new boolean[len], "0");
        
        return set.size();
    }
    
    public void backtracking(String numbers, int len, boolean[] visited, String make) {
        int num = Integer.parseInt(make);
        if (isPrime(num)) set.add(num);
        
        for (int i=0; i<len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backtracking(numbers, len, visited, make+numbers.charAt(i));
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