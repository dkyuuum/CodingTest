function solution(num_list) {
    var answer = 0;
    
    num_list.some((item, idx) => {
        if (item < 0) {
            answer = idx; 
            return true;
        }
        else {
            answer = -1;
        }
    })
    
    return answer;
}