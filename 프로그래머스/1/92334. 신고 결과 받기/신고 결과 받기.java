import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 중복 신고 제거
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // 각 유저별 신고당한 횟수
        Map<String, Integer> reportCount = new HashMap<>();
        
        // 신고 from, to 
        Map<String, List<String>> reportList = new HashMap<>();
        
        for (String s: set) {
            String[] array = s.split(" ");
            String from = array[0];
            String to = array[1];
            
            reportCount.put(to, reportCount.getOrDefault(to, 0)+1);
            
            if (!reportList.containsKey(from)) {
                reportList.put(from, new ArrayList<>());
            }
            reportList.get(from).add(to);
        }
        
        // k번 이상 신고당한 유저
        for (int i=0; i<id_list.length; i++) {
            String id = id_list[i];
            
            for (String reported: reportList.getOrDefault(id, new ArrayList<>())) {
                if (reportCount.get(reported) >= k) {
                       answer[i]+=1;
                }
            }
        }
        return answer;
    }
}