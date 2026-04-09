import java.io.*; 
import java.util.*; 

public class Main { 
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int F = Integer.parseInt(st.nextToken());    // 건물 
        int S = Integer.parseInt(st.nextToken());    // 강호가 지금 있는 층
        int G = Integer.parseInt(st.nextToken());    // 스타트링크 층
        int U = Integer.parseInt(st.nextToken());    // 위로
        int D = Integer.parseInt(st.nextToken());    // 아래로
        
        boolean[] visited = new boolean[F+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        visited[S] = true;
        
        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cur = current[0];
            int count = current[1];
            int[] move = {cur+U, cur-D};
            
            // 도착~
            if (cur == G) {
                System.out.println(count);
                return;
            }
            
            for (int next: move) {
                if (next > F || next < 1) continue;
                if (visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, count+1});
            }
        }
        System.out.println("use the stairs");
    }
}