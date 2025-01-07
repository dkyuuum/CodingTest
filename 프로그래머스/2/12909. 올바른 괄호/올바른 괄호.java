import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char [] arr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(char cur : arr)
        {
           if(cur == '('){
               stack.push(0); 
               continue;
           }
           if(stack.isEmpty() || stack.peek() == 1) return false;
           stack.pop();
        }
        return stack.isEmpty() == true ? true : false;
    }
}