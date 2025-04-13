import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        TreeMap<Long, Integer> map = new TreeMap<>();

        for (int i = 0; i < num; i++) {
            long n = Long.parseLong(br.readLine());
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int max = 0;
        long maxNum = -999;
        for (long number : map.keySet()) {
            int count = map.get(number);
            if (count > max) {
                max = count;
                maxNum = number;
            }
        }
        System.out.println(maxNum);
    }
}