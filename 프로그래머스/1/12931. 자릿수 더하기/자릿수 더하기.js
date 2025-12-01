function solution(n)
{
    var answer = 0;
    
    const m = String(n).split("");
    m.forEach((item) => answer += Number(item));

    return answer;
}