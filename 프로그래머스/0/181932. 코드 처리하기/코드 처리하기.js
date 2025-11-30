function solution(code) {
    var answer = '';
    var mode = 0;
    var ret = '';
    
    var str = code.split("");
    
    for (let idx=0; idx<str.length; idx++) {
        if (mode === 0) {
            if (str[idx] != "1") {
                if (idx % 2 == 0) ret += str[idx];
            } else {
                mode = 1;
            }
        } else if (mode === 1) {
            if (str[idx] != "1") {
                if (idx % 2 == 1) ret += str[idx];
            } else {
                mode = 0;
            }
        }
    }
    
    if (ret === '') {
        answer = "EMPTY";
    } else answer = ret;
    
    return answer;
}