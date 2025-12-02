function solution(numbers) {
    var answer = 0;
    var flag = false;
    
    for (let i=0; i<=9; i++) {
        if (!numbers.includes(i))
            answer += i;
    }
    
    return answer;
}