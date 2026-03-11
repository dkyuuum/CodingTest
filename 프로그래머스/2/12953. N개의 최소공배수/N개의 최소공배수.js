function solution(arr) {
    let answer = arr[0];
    
    for (let i = 1; i < arr.length; i++) {
        answer = nCalc(answer, arr[i]);
    }
    
    return answer;
}

function nCalc(a, b) {
    var temp = a * b;

    while (b !== 0) {
        let temp = a % b;
        a = b;
        b = temp;
    }
    var temp2 = a;

    return temp / temp2;
}