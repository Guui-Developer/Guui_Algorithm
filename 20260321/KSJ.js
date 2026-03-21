let fs = require("fs");
let filePath = process.platform === "linux" ? "/dev/stdin" : "./input.txt";
let input = fs.readFileSync(filePath, "utf8").trim().split("\n");

class Stack {
  constructor(maxSize) {
    this.stack = [];
    this.stackMaxSize = maxSize;
  }

  size() {
    return this.stack.length;
  }

  push(item) {
    if (this.size() === this.stackMaxSize) {
      return null;
    } else {
      this.stack.push(item);
      return item;
    }
  }

  pop(item) {
    if (this.size() === 0) {
      return null;
    } else {
      return this.stack.pop();
    }
  }

  top() {
    if (this.size() === 0) {
      return null;
    } else {
      return this.stack.at(this.stack.length - 1);
    }
  }
}


function solution(input) {
  const stackSize = parseInt(input[0]);
  const stack = new Stack(stackSize);

  let current = 1;
  let result = "";
  for (let i = 1; i < input.length; i++) {
    const target = parseInt(input[i]);

    while (current <= target) {
      stack.push(current);
      result += "+\n";
      current++;
    }

    if (stack.top() === target) {
      stack.pop();
      result += "-\n";
    } else {
      console.log("NO");
      return;
    }
  }
  console.log(result.trim());
}

solution(input);
