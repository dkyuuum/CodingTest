class Solution {
    public int solution(int a, int b) {
        String str1 = Integer.toString(a) + Integer.toString(b);
        String str2 = Integer.toString(b) + Integer.toString(a);
        
        return Math.max(Integer.parseInt(str1), Integer.parseInt(str2));
    }
    
}