const input = require("fs").readFileSync("/dev/stdin").toString().trim();

const one = input.split('0').filter((num) => num !== '');
const zero = input.split('1').filter((num) => num !== '');

console.log(Math.min(one.length, zero.length));
