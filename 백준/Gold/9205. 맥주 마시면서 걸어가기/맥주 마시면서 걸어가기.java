import java.io.*;
import java.util.*;

/**
* 50m마다 맥주 한병
**/ 
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());         // 테스트 케이스의 개수
        
        for (int t=0; t<T; t++) {
            boolean isHappy = false;

            int n = Integer.parseInt(br.readLine());         // 편의점의 개수

            st = new StringTokenizer(br.readLine(), " ");    
            int hx = Integer.parseInt(st.nextToken());       // 상근이네 집 x좌표
            int hy = Integer.parseInt(st.nextToken());       // 상근이네 집 y좌표
            
            int[][] c = new int[n][2];
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine(), " ");    
                int cx = Integer.parseInt(st.nextToken());       // 편의점 x좌표
                int cy = Integer.parseInt(st.nextToken());       // 편의점 y좌표
                
                c[j][0] = cx;
                c[j][1] = cy;
            }

            st = new StringTokenizer(br.readLine(), " ");    
            int fx = Integer.parseInt(st.nextToken());       // 페스티벌 x좌표
            int fy = Integer.parseInt(st.nextToken());       // 페스티벌 y좌표
            
            boolean[] visited = new boolean[n];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{hx, hy});

            while (!q.isEmpty()) {
                int[] cur = q.poll();

                // 페스티벌 바로 갈 수 있는 경우
                if (Math.abs(cur[0] - fx) + Math.abs(cur[1] - fy) <= 1000) {
                    isHappy = true;
                    break;
                } 

                // 거리 1000m가 넘어서 편의점을 들러야하는 경우
                for (int i = 0; i < n; i++) {
                    if (!visited[i]) {
                        int dist = Math.abs(cur[0] - c[i][0]) + Math.abs(cur[1] - c[i][1]);     // 편의점과의 거리 계산

                        if (dist <= 1000) {
                            visited[i] = true;
                            q.add(new int[]{c[i][0], c[i][1]});
                        }
                    }
                }
            }
            if (isHappy) System.out.println("happy");
            else System.out.println("sad");
        }
    }
}