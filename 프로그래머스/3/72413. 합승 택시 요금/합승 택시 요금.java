import java.util.*;

// 지점의 개수 n
// 출발지점 s
// A의 도착지점 a
// B의 도착지점 b

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<>());
        
        for (int[] fare: fares) {
            int n1 = fare[0];
            int n2 = fare[1];
            int m = fare[2];
            
            graph.get(n1).add(new int[]{n2, m});
            graph.get(n2).add(new int[]{n1, m});
        }
        
        int[] distS = dijkstra(graph, n, s);
        int[] distA = dijkstra(graph, n, a);
        int[] distB = dijkstra(graph, n, b);
        
        int mnDist = (int)1e8;
        for (int idx = 0; idx <= n; idx++) {
            int nowDist = distS[idx] + distA[idx] + distB[idx];
            mnDist = Math.min(mnDist, nowDist);
        }
        
        return mnDist;
    }
    
    public int[] dijkstra(List<List<int[]>> graph, int n, int start) {
        int maxValue = (int)1e8;
        int[] dist = new int[n+1];
        Arrays.fill(dist, maxValue);
        
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, start});
        
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            
            int d = first[0];
            int now = first[1];
            
            if (d > dist[now]) continue;
            
            for (int[] nxtNode: graph.get(now)) {
                int nxt = nxtNode[0];
                int nxtDist = d + nxtNode[1];
                
                if (dist[nxt] > nxtDist) {
                    dist[nxt] = nxtDist;
                    pq.add(new int[]{nxtDist, nxt});
                }
            }
        }
        return dist;
    }
}