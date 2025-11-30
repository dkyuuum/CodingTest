function solution(a, b) {
    var answer = 0;
    
    var i = String(a) + String(b);
    var j = 2 * a * b;
    
    if (i >= j) answer = i;
    else answer = j;
    
    return Number(answer);
}