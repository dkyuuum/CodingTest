import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] time = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료
        }

//        Arrays.sort(time);
        Arrays.sort(time, (a, b) -> a[0] - b[0]); 
        
        // 각 강의실이 언제 끝날지 관리
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int start = time[i][0];
            int end = time[i][1];

            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();  // 종료된 강의실을 하나 빼기
            }

            pq.offer(end);
        }

        System.out.println(pq.size());
    }
}
