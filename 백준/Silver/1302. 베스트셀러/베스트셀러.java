import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<num; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0)+1);
        }

        int max = 0;
        String bestSeller = "";
        for (String title: map.keySet()) {
            int count = map.get(title);
            if(count > max) {
                max = count;
                bestSeller = title;
            } else if (count == max) {
                if  (title.compareTo(bestSeller) < 0) {
                    bestSeller = title;
                }
            }
        }
        System.out.println(bestSeller);
    }
}