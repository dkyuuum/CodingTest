import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i=0; i<=n; i++) graph.add(new ArrayList<>());
        for (int[] f: fares) {
            int n1 = f[0];
            int n2 = f[1];
            int cost = f[2];
            
            graph.get(n1).add(new int[]{n2, cost});
            graph.get(n2).add(new int[]{n1, cost});
        }
        
        int[] distA = dijkstra(graph, n, a);
        int[] distB = dijkstra(graph, n, b);
        int[] distS = dijkstra(graph, n, s);
        
        int minValue = (int) 1e8;
        for (int i=0; i<=n; i++) {
            int min = distA[i] + distB[i] + distS[i];
            minValue = Math.min(minValue, min);
        }
        return minValue;
    }
    
    public int[] dijkstra(List<List<int[]>> graph, int n, int start) {
        // 초기 세팅, 시작 노드 예약
        int[] distance = new int[n+1];
        Arrays.fill(distance, (int)1e8);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        pq.add(new int[]{0, start});
        
        // while문
        while(!pq.isEmpty()) {
            int[] first = pq.poll();
            
            int dist = first[0]; // 처음 출발지 ~ 현재 노드까지
            int nowNode = first[1]; // 현재 노드
            
            if (dist > distance[nowNode]) continue;
            
            // 현재 노드에서 인접한 노드들
            for (int[] nxtNode: graph.get(nowNode)) {
                // 다음 노드 번호
                int next = nxtNode[0];
                
                // 다음 노드의 거리
                int nextDist = dist + nxtNode[1];
                
                if  (distance[next] > nextDist) {
                    distance[next] = nextDist;
                    pq.add(new int[]{nextDist, next});
                }
            }
        }
        return distance;
    }
}