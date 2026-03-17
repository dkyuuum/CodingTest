function solution(polynomial) {
    let xSum = 0;
    let numSum = 0;

    let arr = polynomial.split(" + ");

    arr.forEach((item) => {
        if (item.includes("x")) {
            let num = item.replace("x", "");

            if (num === "") {
                xSum += 1;
            } else {
                xSum += Number(num);
            }
        } else {
            numSum += Number(item);
        }
    });

    let answer = "";

    if (xSum > 0) {
        answer += (xSum === 1 ? "x" : xSum + "x");
    }

    if (numSum > 0) {
        if (answer !== "") answer += " + ";
        answer += numSum;
    }

    return answer;
}