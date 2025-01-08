import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String str = " " + s;

        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i - 1) == ' '){
                answer += Character.toUpperCase(str.charAt(i));
            } else {
                answer += Character.toLowerCase(str.charAt(i));
            }
        }

        return answer;
    }
}