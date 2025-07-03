class Solution {
    public int count = 0;
    public int solution(int[] numbers, int target) {
        backtracking(numbers, target, 0, 0);
        return count;
    }
    
    public void backtracking(int[] numbers, int target, int index, int make) {
        if (numbers.length == index) {
            if (target == make) count++;
            return;
        }
        
        backtracking(numbers, target, index+1, make+numbers[index]);
        backtracking(numbers, target, index+1, make-numbers[index]);
    }
}