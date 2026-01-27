function solution(clothes) {
    var answer = 1;
    const hashMap = new Map();

    clothes.forEach((item, index) => {
        const [cloth, type] = item;
        if (!hashMap.has(type)) {
            hashMap.set(type, 1);
        } else {
            hashMap.set(type, hashMap.get(type)+1);
        }
    })
    
    // 모든 경우의 수
    for (const [cloth, type] of hashMap) {
        answer *= (type + 1)
    }

    // 아무것도 착용하지 않는 경우
    return (answer - 1); 
}