function solution(array, height) {
    var answer = 0;
    
    array.forEach((item, idx) => {
        if (item > height) {
            answer++;
        }
    })
    
    return answer;
}