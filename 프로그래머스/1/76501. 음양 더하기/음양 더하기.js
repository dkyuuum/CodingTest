function solution(absolutes, signs) {
    var answer = 0;
    
    signs.forEach((item, idx) => {
        if (item === true) {
            answer += absolutes[idx];
        } else {
            answer -= absolutes[idx];
        }
    })
    
    return answer;
}