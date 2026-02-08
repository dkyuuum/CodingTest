function solution(t, p) {
    var answer = 0;
    var len = p.length;
    var st = t.split("");
    var lengt = t.length - len + 1;

    for (let i=0; i<lengt; i++) {
        var sub = t.substr(i, len);

        if (sub <= p) {
            answer++;
            console.log(sub)
        }
    }    
    
    return answer;
}