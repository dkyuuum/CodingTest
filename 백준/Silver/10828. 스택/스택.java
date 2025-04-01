import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                int num = Integer.parseInt(command.split(" ")[1]);
                stack.push(num);
                continue;
            } else if (command.equals("pop")) {
                result = stack.isEmpty() ? -1 : stack.pop();
            } else if (command.equals("size")) {
                result = stack.size();
            } else if (command.equals("empty")) {
                result = stack.isEmpty() ? 1 : 0;
            } else if (command.equals("top")) {
                result = stack.isEmpty() ? -1 : stack.peek();
            }
                System.out.println(result);
        }
    }
}