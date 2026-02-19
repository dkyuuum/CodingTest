import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        
        for (int i=0; i<len; i++) {
            int a = commands[i][0] - 1;
            int b = commands[i][1];
            int c = commands[i][2] - 1;
            
            int[] temp = new int[b-a];
            for (int j=a, k=0; j<b; j++, k++) {
                temp[k] = array[j];
            }
            Arrays.sort(temp);
            answer[i] = temp[c];
        }
        
        return answer;
    }
}