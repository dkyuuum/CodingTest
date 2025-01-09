class Solution {
    public int[] solution(String s) {
        // 회차
        int count = 0;
        
        // 0 갯수
        int zero = 0;
        
        while(s.length()>1) {
            int before = s.length();
            s = s.replaceAll("0", "");
            
            int after = s.length();
            zero += before - after;
            
            s = binary("", s.length());
            
            count++;
            
        }
         
        return new int[]{count, zero};
    }
    
    private String binary(String str, int len) {
        if (len == 1) return "1";
        int num = len / 2;
        int re = len % 2;
        
        if (num <= 1) {
            return String.valueOf(num) + String.valueOf(re)+str;
        } else {
            return binary(String.valueOf(re)+str, num);
        }
        
    }
}