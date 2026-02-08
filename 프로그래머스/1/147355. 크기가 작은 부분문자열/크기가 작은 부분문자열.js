function solution(t, p) {
    var answer = 0;
    var pLen = p.length;
    var tLen = t.length;
    var st = t.split("");

    for (let i=0; i<tLen - pLen + 1; i++) {
        var sub = t.substr(i, pLen);

        if (sub <= p) {
            answer++;
        }
    }    
    
    return answer;
}
