import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        
        // 현재 시간, 총 작업 시간, 완료된 작업수, 인덱스
        int total = 0;
        int current = 0;
        int completed = 0;
        int index = 0;
        int len = jobs.length;
        
        while (len > completed) {
            while (len > index && current >= jobs[index][0]) {
                pq.add(jobs[index]);
                index++;
            }
            
            if (!pq.isEmpty()) {
                int[] job = pq.remove();
                
                current += job[1];
                total += current - job[0];
                completed++;
            } else {
                current = jobs[index][0];
            }
        } 
        return total / len;
    }
}