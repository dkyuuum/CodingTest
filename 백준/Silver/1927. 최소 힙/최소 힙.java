import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int input = 0;
          for (int i = 0; i < n; i++) {
                input = Integer.parseInt(br.readLine());

                if (input > 0) {
                    queue.offer(input);
                } else {
                    if (queue.isEmpty()) {
                        System.out.println(0);
                    } else {
                        System.out.println(queue.poll());
                    }
                }
          }
    }
}