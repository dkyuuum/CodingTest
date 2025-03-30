import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String[] str = sc.nextLine().split("");
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length; i++) {
            String checkStr = str[i].toUpperCase();
            map.put(checkStr, map.getOrDefault(checkStr, 0) + 1);
        }

        int max = 0;
        for (int value : map.values()) {
            if (value > max) {
                max = value;
            }
        }

        String answer = "";
        int count = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                count++;
                answer = key;
            }
        }

        System.out.println(count > 1 ? "?" : answer);

        sc.close();
    }
}
