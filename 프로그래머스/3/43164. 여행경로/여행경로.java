import java.util.*;
import java.io.*;

class Solution {
    static String[] answer;
    static boolean found = false;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        boolean[] visited = new boolean[tickets.length];
        List<String> route = new ArrayList<>();
        route.add("ICN");
        
        dfs("ICN", tickets, visited, route, 0);
        
        return answer;
    }
    
    public void dfs(String start, String[][] tickets, boolean[] visited, List<String> route, int count) {
        if (found) return;                               // 이미 찾았으면 종료
        
        if (count == tickets.length) {
            answer = route.toArray(new String[0]);
            found = true;
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                
                dfs(tickets[i][1], tickets, visited, route, count + 1);
                
                visited[i] = false;                     // 백트래킹
                route.remove(route.size() - 1);
            }
        }
    }
}