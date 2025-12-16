function solution(progresses, speeds) {
    const answer = [];
    
    // 1. 완료까지 걸리는 날짜 계산
    const days = progresses.map((item, i) =>
        Math.ceil((100 - item) / speeds[i])
    );

    // 2. 배포 기준
    let maxDay = days[0];
    let count = 1;

    for (let i = 1; i < days.length; i++) {
        if (days[i] <= maxDay) {
            // 같이 배포
            count++;
        } else {
            // 새로운 배포
            answer.push(count);
            maxDay = days[i];
            count = 1;
        }
    }

    // 마지막 배포
    answer.push(count);
    return answer;
}
