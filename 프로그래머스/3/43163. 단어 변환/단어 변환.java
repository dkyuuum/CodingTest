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
        boolean[] visited = new boolean[words.length];
        return bfs(begin, target, words, visited);
    }
    
    public int bfs(String begin, String target, String[] words, boolean[] visited) {
        Queue<Word> queue = new ArrayDeque<>();
        queue.offer(new Word(begin, 0));

        while(!queue.isEmpty()) {
            Word cur = queue.poll(); // 현재값
            
            if (cur.word.equals(target)) return cur.count; // 타겟과 현재 단어가 같을 때
                
            for (int i=0; i<words.length; i++) {
                int diff = 0;
                
                for (int j=0; j<cur.word.length(); j++) {
                    if (cur.word.charAt(j) != words[i].charAt(j)) { diff++; }
                }
                
                if (diff == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Word(words[i], cur.count+1));
                }
            }
        }
        
        return 0;
    }
}