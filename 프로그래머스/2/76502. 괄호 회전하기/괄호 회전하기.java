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
        
        for (char t: s.toCharArray()) {
            if (t == '(' || t == '[' || t == '{') { stack.push(t); }
            else {
                if (stack.isEmpty()) return false;
                
                char c = stack.pop();
                if ((c == '(' && t != ')' )|| (c == '[' && t != ']') || (c == '{' && t != '}')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}