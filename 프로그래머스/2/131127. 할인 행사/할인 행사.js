function solution(want, number, discount) {
    let answer = 0;

    const wantMap = new Map();
    want.forEach((item, idx) => {
        wantMap.set(item, number[idx]);
    });

    const currentMap = new Map();

    for (let i = 0; i < 10; i++) {
        currentMap.set(
            discount[i],
            (currentMap.get(discount[i]) || 0) + 1
        );
    }

    const isSame = () => {
        for (let [key, value] of wantMap) {
            if (currentMap.get(key) !== value) {
                return false;
            }
        }
        return true;
    };

    if (isSame()) answer++;

    // 슬라이딩 윈도우
    for (let i = 10; i < discount.length; i++) {
        // 제거
        const removeItem = discount[i - 10];
        currentMap.set(removeItem, currentMap.get(removeItem) - 1);
        if (currentMap.get(removeItem) === 0) {
            currentMap.delete(removeItem);
        }

        // 추가
        const addItem = discount[i];
        currentMap.set(addItem, (currentMap.get(addItem) || 0) + 1);

        if (isSame()) answer++;
    }

    return answer;
}
