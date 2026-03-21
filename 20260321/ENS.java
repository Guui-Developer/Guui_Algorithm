import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    입력받은 값에 대해서 stack에 순서대로 뺄수있는지
    1부터 체크하여 뺄수있는지 체크를 한다.
    1. 해당 값이 현재 빼야되는 값인지 체크한다.
    2. 아니면 push 맞으면 pop
    3. 만약 push를 전부했는데 pop이 될게 없다면 no로 던져줘야한다.

    어떻게 보관할껀지? Queue 이용
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> waiting = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            waiting.offer(Integer.parseInt(br.readLine()));
        }

        sb.append("+").append("\n");
        stack.push(1);

        int index = 2;
        while (index <= t) {
            Integer waitingTop = waiting.peek();

            if (!stack.isEmpty()) {
                if (waitingTop.equals(stack.peek())) {
                    waiting.poll();
                    stack.pop();
                    sb.append("-").append("\n");
                    continue;
                }
            }

            sb.append("+").append("\n");
            stack.push(index);
            index++;
        }

        while (!stack.isEmpty()) {
            Integer waitingTop = waiting.peek();
            Integer stackTop = stack.peek();

            if (waitingTop.equals(stackTop)) {
                waiting.poll();
                stack.pop();
                sb.append("-").append("\n");
            } else {
                bw.write("NO");
                bw.flush();
                bw.close();
                return;
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
            bw.write(sb.toString());
        }

        bw.flush();
        bw.close();
    }
}
