import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<int[]>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalMap.put(genres[i],
                totalMap.getOrDefault(genres[i], 0) + plays[i]);

            songMap.putIfAbsent(genres[i], new ArrayList<>());
            songMap.get(genres[i]).add(new int[]{plays[i], i});
        }

        List<String> genreList = new ArrayList<>(totalMap.keySet());
        genreList.sort((a, b) -> totalMap.get(b) - totalMap.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : genreList) {
            List<int[]> list = songMap.get(genre);

            list.sort((a, b) -> {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            });

            result.add(list.get(0)[1]);
            if (list.size() > 1) result.add(list.get(1)[1]);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}