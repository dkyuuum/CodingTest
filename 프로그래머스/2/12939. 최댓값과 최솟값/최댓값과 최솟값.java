import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] tmpArr = s.split(" "); 
        
        int[] result = new int[tmpArr.length];
        
        for (int i = 0; i < result.length;i++){
            result[i] = Integer.parseInt(tmpArr[i]);
        }
        
        Arrays.sort(result);    
        
        return result[0] + " " + result[result.length-1];
    }
}