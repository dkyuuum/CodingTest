function solution(elements) {
  // 중복이 안담기게 set을 사용
  const set = new Set();
  const n = elements.length;
  // elements에 마지막 요소만 빼고 합쳐주었따.
  const arr = [...elements, ...elements.slice(0, n - 1)];

  // 이중 for문으로 sum값을 구함
  for (let i = 1; i <= n; i++) {
    for (let j = 0; j < n; j++) {
      const sum = arr.slice(j, j + i).reduce((a, b) => a + b, 0);
      // set에 추가
      set.add(sum);
    }
  }

  // set의 길이
  return set.size;
}