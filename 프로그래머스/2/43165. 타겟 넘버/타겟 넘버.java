class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        backtracking(numbers, target, 0, 0);
        
        return answer;
    }
    
    public void backtracking(int[] numbers, int target, int make, int index) {
        if (numbers.length == index) {
            if (make == target)
                answer++;
            return;
        }
        
        backtracking(numbers, target, make+numbers[index], index+1);
        backtracking(numbers, target, make-numbers[index], index+1);
    }
}