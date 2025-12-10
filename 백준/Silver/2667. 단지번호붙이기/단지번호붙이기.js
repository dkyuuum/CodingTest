const input = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n');

const N = Number(input.shift());
const M = input.map((line) => line.split('').map(Number));

const map = input.map((v) => v.split('').map(Number));
const ds = [
  [1, 0],
  [-1, 0],
  [0, 1],
  [0, -1],
];
let answer = [];

const bfs = (start) => {
  const queue = [start];
  let cnt = 0; // 단지내 집의 개수

  while (queue.length) {
    const [curY, curX] = queue.shift();
    cnt++;

    for (let i = 0; i < 4; i++) {
      const ny = curY + ds[i][1];
      const nx = curX + ds[i][0];

      // 다음 위치가 지도 밖으로 벗어나지 않고 집이 있는 곳(1)이라면
      if (ny >= 0 && ny < N && nx >= 0 && nx < N && map[ny][nx]) {
        map[ny][nx] = 0; // 방문 처리
        queue.push([ny, nx]); // 해당 위치 큐에 담기
      }
    }
  }
  return cnt;
};

for (let i = 0; i < N; i++) {
  for (let j = 0; j < N; j++) {
    if (map[i][j]) {
      // 집이 있는 곳(1)이면
      map[i][j] = 0; // 방문 처리
      answer.push(bfs([i, j]));
    }
  }
}
console.log(answer.length);
console.log(answer.sort((a, b) => a - b).join('\n'));
