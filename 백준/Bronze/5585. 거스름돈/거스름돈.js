const input = require('fs').readFileSync('/dev/stdin').toString().trim();

let change = 1000 - Number(input);
const std = [500, 100, 50, 10, 5, 1];
let cnt = 0;

for (let i = 0; i < std.length; i++) {
  cnt += Math.floor(change / std[i]);
  change = change % std[i];
}

console.log(cnt);
