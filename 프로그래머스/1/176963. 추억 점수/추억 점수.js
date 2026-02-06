function solution(name, yearning, photo) {
    var answer = [];
    var map = new Map();
    
    // 이름 → 점수 매핑
    name.forEach((item, index) => {
        map.set(item, yearning[index]);
    });
    
    // 사진별 점수 계산
    photo.forEach((people) => {
        let sum = 0;
        
        people.forEach((person) => {
            if (map.has(person)) {
                sum += map.get(person);
            }
        });
        
        answer.push(sum);
    });
    
    return answer;
}
