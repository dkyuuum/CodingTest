import java.util.*;

class Solution {
    static class Word {
        String word;
        int count;
        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        Queue<Word> queue = new LinkedList<>();
        
        queue.offer(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word cur = queue.poll();
            
            if (cur.word.equals(target)) return cur.count;
            
            for (int i=0; i<words.length; i++) {
                int diff = 0;
                
                for (int j=0; j<words[i].length(); j++) {
                    if (cur.word.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                
                if (diff == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(new Word(words[i], cur.count+1));
                }
            }
        }
        return 0;
    }
}