function solution(n, s) {
    if (n > s) { 
        return [-1];
    };
    
    const a = Math.floor(s / n); 
    const rest = s % n;             

    const answer = Array(n).fill(a);

    for (let i = n - rest; i < n; i++) {
        answer[i] += 1;
    }
    
    return answer;
}