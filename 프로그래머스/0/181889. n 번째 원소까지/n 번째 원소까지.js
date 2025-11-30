function solution(num_list, n) {
    var answer = [];
    
    num_list.forEach((item, idx) => {
        if (n >= idx+1) {
            answer.push(item);
        }
    })
    
    return answer;
}