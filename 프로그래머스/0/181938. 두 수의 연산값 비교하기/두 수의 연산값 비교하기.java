class Solution {
    public int solution(int a, int b) {
        String answerStr = Integer.toString(a) + Integer.toString(b);
        int answer = 2 * a * b;
        
        answer = Math.max(Integer.parseInt(answerStr), answer);
        return answer;
    }
}