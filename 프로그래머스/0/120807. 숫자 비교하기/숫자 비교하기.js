function solution(num1, num2) {
    var answer = 0;
    
    switch(num1-num2) {
        case 0:
            answer = 1;
            break;
        default:
            answer = -1;
            break;
    }
    
    return answer;
}