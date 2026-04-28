import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Integer> totalMap = new HashMap<>();    // 장르별 총 재생 횟수
        Map<String, List<int[]>> songMap = new HashMap<>();     // 노래 순서
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            totalMap.put(genre, totalMap.getOrDefault(genre, 0)+play);
            
            songMap.putIfAbsent(genre, new ArrayList<>());
            songMap.get(genre).add(new int[]{play, i});
        }
        
        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));
        
        List<Integer> result = new ArrayList<>();
        
        for (String genre : genreList) {
            List<int[]> songs = songMap.get(genre);
            
            // 재생수 내림차순, 인덱스 오름차순
            songs.sort((a, b) -> {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            });
            
            // 최대 2개 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[1]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}