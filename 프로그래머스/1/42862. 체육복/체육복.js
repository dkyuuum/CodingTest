function solution(n, lost, reserve) {
    // 1. 정렬
    lost.sort((a, b) => a - b);
    reserve.sort((a, b) => a - b);

    // 2. lost & reserve 겹치는 학생 제거
    let realLost = lost.filter(l => {
        if (reserve.includes(l)) {
            reserve.splice(reserve.indexOf(l), 1);
            return false;
        }
        return true;
    });

    // 3. 체육복 빌려주기
    let answer = n - realLost.length;

    for (let i = 0; i < realLost.length; i++) {
        let student = realLost[i];

        if (reserve.includes(student - 1)) {
            reserve.splice(reserve.indexOf(student - 1), 1);
            answer++;
        } 
        else if (reserve.includes(student + 1)) {
            reserve.splice(reserve.indexOf(student + 1), 1);
            answer++;
        }
    }

    return answer;
}
