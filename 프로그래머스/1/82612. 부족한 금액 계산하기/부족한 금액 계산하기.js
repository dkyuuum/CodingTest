function solution(price, money, count) {
    var answer = -1;
    
    var tem = 0;
    for (let i=0; i < count; i++) {
        tem += price * (i + 1);
    }
    
    if (money - tem >= 0) {
        answer = 0;
    } else if (money - tem < 0) {
        answer = tem - money;
    }

    return answer;
}