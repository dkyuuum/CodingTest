import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i=0; i<s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (isValid(rotated)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char t = stack.pop();
                if ((c == ')' && t != '(') || (c == '}' && t != '{') || (c == ']' && t != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}