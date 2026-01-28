function solution(k, tangerine) {
    let answer = 0;

    const map = new Map();

    // 1. 귤 크기별 개수 세기
    tangerine.forEach(size => {
        map.set(size, (map.get(size) || 0) + 1);
    });

    // 2. 개수만 뽑아서 내림차순 정렬
    const counts = [...map.values()].sort((a, b) => b - a);

    // 3. 많은 것부터 k에서 빼기
    for (let count of counts) {
        k -= count;
        answer++;
        if (k <= 0) break;
    }

    return answer;
}