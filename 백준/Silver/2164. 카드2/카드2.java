import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() > 1) {
            queue.pollFirst();                  // 제일 위에 있는 카드 버리기
            int move = queue.pollFirst();       // 제일 위에 있는 카드를 밑으로 옮기기
            queue.addLast(move);
        }
        System.out.println(queue.peek());
    }
}