import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
//        666 1666 2666 3666 4666 5666 6666 7666 8666 9666
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        for (int answer = 666; ; answer++) {
            if (String.valueOf(answer).contains("666")) {
                count++;
                if (count == N) { // 원했던 N번째와 count가 같을 떄
                    System.out.println(answer);
                    break;
                }
            }
        }
    }
}