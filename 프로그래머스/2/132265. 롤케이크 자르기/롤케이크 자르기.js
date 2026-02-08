function solution(topping) {
    var answer = 0;
    var rightMap = new Map();
    var leftSet = new Set();
    
    // 오른쪽 전체 토핑 개수 세기
    topping.forEach((item) => {
        rightMap.set(item, (rightMap.get(item) || 0) + 1);
    });
    
    // 하나씩 자르면서 비교
    for (let i = 0; i < topping.length - 1; i++) {
        const t = topping[i];
        
        // 왼쪽에 추가
        leftSet.add(t);
        
        // 오른쪽에서 제거
        rightMap.set(t, rightMap.get(t) - 1);
        if (rightMap.get(t) === 0) {
            rightMap.delete(t);
        }
        
        // 종류 수 비교
        if (leftSet.size === rightMap.size) {
            answer++;
        }
    }
    
    return answer;
}
