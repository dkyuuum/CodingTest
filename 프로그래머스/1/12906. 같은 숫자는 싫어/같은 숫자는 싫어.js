function solution(arr)
{
    var answer = [];
    
    // arr.forEach((item) => {
    //     if(!answer.find((i) => i === item)) {
    //        answer.push(item);
    //      }
    // })
    for (let i=0; i<arr.length; i++) {
        if (arr[i-1] != arr[i]) {
            answer.push(arr[i]);
        }
    }
    console.log(answer);
    
    
    return answer;
}