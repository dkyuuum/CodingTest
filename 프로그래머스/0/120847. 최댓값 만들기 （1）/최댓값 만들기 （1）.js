function solution(numbers) {
    var answer = 0;
    
    var sort = numbers.sort((a, b) => a-b);
    var answer = sort[numbers.length-1] * sort[numbers.length-2];
    
    return answer;
}