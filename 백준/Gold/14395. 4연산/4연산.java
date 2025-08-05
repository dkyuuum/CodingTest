import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        long num;
        String ops;

        Pair(long num, String ops) {
            this.num = num;
            this.ops = ops;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long s = Long.parseLong(input[0]);
        long t = Long.parseLong(input[1]);

        if (s == t) {
            System.out.println(0);
            return;
        }

        Queue<Pair> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        queue.add(new Pair(s, ""));
        visited.add(s);

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();

            long n;

            // * 연산
            n = cur.num * cur.num;
            if (n == t) {
                System.out.println(cur.ops + "*");
                return;
            }
            if (n <= 1000000000 && visited.add(n)) {
                queue.add(new Pair(n, cur.ops + "*"));
            }

            // + 연산
            n = cur.num + cur.num;
            if (n == t) {
                System.out.println(cur.ops + "+");
                return;
            }
            if (n <= 1000000000 && visited.add(n)) {
                queue.add(new Pair(n, cur.ops + "+"));
            }

            // - 연산 (0)
            n = 0;
            if (n == t) {
                System.out.println(cur.ops + "-");
                return;
            }
            if (visited.add(n)) {
                queue.add(new Pair(n, cur.ops + "-"));
            }

            // / 연산 (1)
            if (cur.num != 0) {
                n = 1;
                if (n == t) {
                    System.out.println(cur.ops + "/");
                    return;
                }
                if (visited.add(n)) {
                    queue.add(new Pair(n, cur.ops + "/"));
                }
            }
        }

        System.out.println(-1);
    }
}
