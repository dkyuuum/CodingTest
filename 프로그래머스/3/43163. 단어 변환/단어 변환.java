import java.util.*;

class Solution {
    public static int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        int depth = 0;

        queue.add(begin);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 단계의 단어 개수

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return depth;

                String[] cSplit = current.split("");

                for (int j = 0; j < words.length; j++) {
                    if (!visited[j]) {
                        String[] wSplit = words[j].split("");
                        int count = 0;

                        for (int k = 0; k < cSplit.length; k++) {
                            if (!cSplit[k].equals(wSplit[k])) count++;
                            if (count > 1) break;
                        }

                        if (count == 1) {
                            visited[j] = true;
                            queue.add(words[j]);
                        }
                    }
                }
            }

            depth++;
        }

        return 0;
    }
}
