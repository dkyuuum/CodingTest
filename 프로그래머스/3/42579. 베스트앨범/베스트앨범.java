import java.util.*;

class Solution {
    class Song {
        String genre;
        int play;
        int index;
        
        Song(String genre, int play, int index) {
            this.genre = genre;
            this.play = play;
            this.index = index;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        List<Song> list = new ArrayList<>();
        Map<String, Integer> totalMap = new HashMap<>();
        
        // 1. 데이터 세팅
        for (int i = 0; i < genres.length; i++) {
            list.add(new Song(genres[i], plays[i], i));
            totalMap.put(genres[i],
                totalMap.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 2. 정렬
        list.sort((a, b) -> {
            // 장르 총합 기준
            if (!a.genre.equals(b.genre)) {
                return totalMap.get(b.genre) - totalMap.get(a.genre);
            }
            // 재생 수 기준
            if (b.play != a.play) {
                return b.play - a.play;
            }
            // 인덱스 기준
            return a.index - b.index;
        });
        
        // 3. 장르별 2개만 선택
        Map<String, Integer> countMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for (Song song : list) {
            countMap.putIfAbsent(song.genre, 0);
            
            if (countMap.get(song.genre) < 2) {
                result.add(song.index);
                countMap.put(song.genre, countMap.get(song.genre) + 1);
            }
        }
        
        // int[] answer = new int[result.size()];
        // for (int i = 0; i < result.size(); i++) {
        //     answer[i] = result.get(i);
        // }
        // return answer;
        return result.stream().mapToInt(i -> i).toArray();
    }
}