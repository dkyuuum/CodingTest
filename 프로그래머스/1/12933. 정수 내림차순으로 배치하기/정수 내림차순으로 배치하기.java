import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        long[] arr;
        
        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String s: str) {
            System.out.print(s);
            sb.append(s);
        }
        
        return Long.parseLong(sb.toString());
    }
}