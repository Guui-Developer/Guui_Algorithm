let fs = require("fs");
let filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath, "utf8").trim().split("\n");

let N;
N = Number(input[0]);

const OPTION3 = 3;
const OPTION5 = 5;

function solution(sugar) {
  let kg5count = parseInt(sugar / OPTION5);
  let kg3count = parseInt((sugar % OPTION5) / OPTION3);
  let remain = sugar - (kg3count * OPTION3 + kg5count * OPTION5);

  while (true) {
    if (kg5count === -1) {
      console.log(-1);
      break;
    }

    if (remain === 0) {
      console.log(kg3count + kg5count);
      break;
    } else {
      kg5count--;
      remain += OPTION5;
      kg3count += parseInt(remain / OPTION3);
      remain = remain % OPTION3;
    }
  }
}

solution(N);
