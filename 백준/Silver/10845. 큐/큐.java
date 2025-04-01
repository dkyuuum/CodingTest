import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        int rear = 0;

        int count = Integer.parseInt(br.readLine());

        for (int i=0; i<count; i++) {
            String command = br.readLine();

            if (command.startsWith("push")) {
                rear = Integer.parseInt(command.split(" ")[1]);
                queue.offer(rear);
                continue;
            } else if (command.startsWith("pop")) {
                result = (queue.isEmpty() ? -1 : queue.poll());
            }  else if (command.startsWith("size")) {
                result = queue.size();
            } else if (command.startsWith("empty")) {
                result = (queue.isEmpty() ? 1 : 0);
            } else if (command.startsWith("front")) {
                result = (queue.isEmpty() ? -1 : queue.peek());
            } else if (command.startsWith("back")) {
                result = (queue.isEmpty() ? -1 : rear);
            }
            System.out.println(result);
        }
    }
}
