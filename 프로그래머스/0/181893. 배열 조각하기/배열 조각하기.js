function solution(arr, query) {
    var answer = arr;
    var len = arr.length;
    
    query.forEach((item, idx) => {
        if (idx % 2 == 0) {
            answer.splice(item+1, len);
            console.log(answer)
        } else {
            answer.splice(0, item);
            console.log(answer)
        }
    })
    
    return answer;
}