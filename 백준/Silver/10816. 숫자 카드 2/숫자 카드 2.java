//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        int n = Integer.parseInt(br.readLine());
//
//        StringTokenizer st1 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//             map.put(Integer.parseInt(st1.nextToken()), 0);
//        }
//
//        int m = Integer.parseInt(br.readLine());
//        StringTokenizer st2 = new StringTokenizer(br.readLine());
//        for (int i = 0; i < m; i++) {
//            int num = Integer.parseInt(st2.nextToken());
//            if (map.containsKey(num)) {
//                map.put(map.get(mArray[i]) + 1);
//            }
//        }
//        for (int value : map.values()) {
//            System.out.print(value+ " ");
//        }
//
//    }
//}
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st1.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st2.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb.toString());
    }
}
