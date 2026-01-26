function solution(n) {
  const MOD = 1234567;

  let prev = 0;
  let curr = 1;

  for (let i = 2; i <= n; i++) {
    let next = (prev + curr) % MOD;
    prev = curr;
    curr = next;
  }

  return curr;
}
