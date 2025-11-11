import java.util.Stack;

class Solution {
    public int solution(String s) {
        // 문자를 저장할 스택
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            // 스택이 비어있다면 현재 문자를 스택에 추가
            if (stack.isEmpty()) { 
                stack.push(s.charAt(i));
            } else {
                // 현재 문자
                char ch = s.charAt(i); 

                // 스택의 맨 위 문자와 현재 문자가 같다면 스택에서 제거
                if (stack.peek() == ch) {
                    stack.pop();
                } 
                // 같지 않다면 현재 문자를 스택에 추가
                else {
                    stack.push(ch);
                }
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}
