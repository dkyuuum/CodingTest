const fs = require("fs");
const filePath =
  process.platform === "linux" ? "/dev/stdin" : "./Z_Test/input.txt";
let input = fs.readFileSync(filePath).toString().trim().split("\n");

const [n, m, v] = input[0].split(" ").map((item) => +item);

const graph = Array.from({ length: n + 1 }, () => []);

// 그래프 세팅
for (let i = 0; i < m; i++) {
  const [from, to] = input[1 + i].split(" ").map((item) => +item);
  graph[from].push(to);
  graph[to].push(from);
}

// 그래프 정점번호 작은순으로 정렬 -> 인접리스트화
for (let i = 0; i < n; i++) {
  graph[i + 1].sort((a, b) => a - b);
}

// dfs,bfs visited, answer 세팅
let dfs_visited = Array.from({ length: n + 1 }, () => 0);
let dfs_answer = [];

let bfs_visited = Array.from({ length: n + 1 }, () => 0);
let bfs_answer = [];

// DFS는 재귀방식으로 풀이
const DFS = (v) => {
  // 이미방문한경우
  if (dfs_visited[v] === 1) {
    return;
  }
  // 새로방문한경우
  else {
    dfs_visited[v] = 1;
    dfs_answer.push(v);
    for (let i = 0; i < graph[v].length; i++) {
      let nextNode = graph[v][i];
      if (dfs_visited[nextNode] === 0) {
        DFS(nextNode);
      }
    }
  }
};
// BFS는 큐에 계속 추가시켜서 while문을 돌려서 풀이
const BFS = (v) => {
  let queue = [v];

  while (queue.length) {
    // 타겟으로 설정하면서 큐에서 제거.
    let target = queue.shift();
    // 이미 방문한경우
    if (bfs_visited[target] === 1) {
      continue;
    }

    // 새로 방문한 경우
    else {
      bfs_visited[target] = 1;
      bfs_answer.push(target);
      for (let i = 0; i < graph[target].length; i++) {
        let nextNode = graph[target][i];
        queue.push(nextNode);
      }
    }
  }
};

const arr = [1, 2, 3, 4, 5];

DFS(v);
BFS(v);

console.log(dfs_answer.join(" "));
console.log(bfs_answer.join(" "));