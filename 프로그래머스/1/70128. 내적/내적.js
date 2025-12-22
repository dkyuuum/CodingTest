function solution(a, b) {
    var answer = 0;
    
    a.forEach((item, idx) => {
        answer += item * b[idx];
    })
    
    return answer;
}