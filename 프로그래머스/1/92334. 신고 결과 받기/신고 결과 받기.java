import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // 중복되는 신고 없애기
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        // System.out.println(reportSet);
        
        // 신고 받은 횟수
        Map<String, Integer> reportCount = new HashMap<>();
        Map<String, List<String>> iReportWho = new HashMap<>();
        
        for (String s : reportSet){
            String[] part = s.split(" ");
            String from = part[0]; // 신고한 사람
            String to = part[1]; // 신고 당한 사람
            
            reportCount.put(to, reportCount.getOrDefault(to, 0) + 1);
            
            if(!iReportWho.containsKey(from)){
                iReportWho.put(from, new ArrayList<>());
            }
            iReportWho.get(from).add(to);
        }
        
        // K번 이상 신고받은 사람들 찾기
        for(int i = 0; i < id_list.length; i++){
            String reporter = id_list[i];
            for(String reportee: iReportWho.getOrDefault(reporter, new ArrayList<>())){
                if(reportCount.get(reportee) >= k){
                    answer[i] += 1;
                }
            }
        }
            // 제재 받은 사람을 신고한 사람한테 알림주기 answer[i]++;
        return answer;
    }
}
