import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
//        Set<Integer> set = new HashSet<>();
        for (int i=0 ; i<N; i++) {
//            set.add(Integer.parseInt(st.nextToken()));
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        List<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            map.put(sorted.get(i), i);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(map.get(num)).append(' ');
        }

        System.out.println(sb);
    }
}