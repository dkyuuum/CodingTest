function solution(numbers, num1, num2) {
    var answer = [];
    
    for (var i=num1; i<num2+1; i++) {
        answer.push(numbers[i]);
    }
    
    return answer;
}