let fs = require("fs");
let filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath, "utf8").trim().split("\n");

grade_map = {
    "A+": 4.5,
    "A0": 4.0,
    "B+": 3.5,
    "B0": 3.0,
    "C+": 2.5,
    "C0": 2.0,
    "D+": 1.5,
    "D0": 1.0,
    "F": 0.0,
  };

  total_weighted = 0.0;
  total_credits = 0.0;
  
  function solution(input) {
    for (let i = 0; i < input.length; i++) {
      let currentArr = input[i].split(" ");
      let credit = parseFloat(currentArr[1]);
      let grade = currentArr[2];
  
      if (grade === "P") continue;
  
      total_weighted += credit * grade_map[grade];
      total_credits += credit;
    }
  
    console.log(total_weighted / total_credits);
  }
  
  solution(input);