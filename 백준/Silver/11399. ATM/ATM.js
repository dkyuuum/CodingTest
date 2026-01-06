const input = require('fs')
  .readFileSync('dev/stdin')
  .toString()
  .trim()
  .split('\n');

const N = Number(input.shift());
const P = input
  .shift()
  .split(' ')
  .map((num) => Number(num));

P.sort((a, b) => a - b);

let answer = 0;
for (let i = 0; i < N; i++) {
  let sum = P[i];
  for (let j = 0; j < i; j++) {
    sum += P[j];
  }
  answer += sum;
}
console.log(answer);
