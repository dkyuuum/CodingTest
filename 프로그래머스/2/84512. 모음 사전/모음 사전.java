class Solution {
    static int count = 0;
    static int answer = 0;
    static boolean found = false;
    
    public int solution(String word) {
        dfs("", word);
        return answer;
    }
    
    public void dfs(String current, String target) {
        if (found) return;
        
        if (current.equals(target)) {
            answer = count;
            found = true;
            return;
        }
        
        if (current.length() == 5) return;
        
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        
        for (char c : vowels) {
            count++;
            dfs(current + c, target);
        }
    }
}