function solution(brown, yellow) {
    var answer = [];
    var total = brown + yellow;

    for (let h = 1; h <= Math.sqrt(total); h++) {
        if (total % h === 0) {
            let w = total / h;

            // 가로가 세로보다 크거나 같아야 함
            if (w >= h) {
                // 노란색 영역 체크
                if ((w - 2) * (h - 2) === yellow) {
                    answer = [w, h];
                    break;
                }
            }
        }
    }

    return answer;
}
