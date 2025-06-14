import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int countA = 0; // a 갯수
        for (char c: str.toCharArray()) {
            if (c == 'a') countA++;
        }

        String doubleStr = str+str; // 원형

        int countB = 0; // B 갯수
        int minB = 999;
        for (int i=0; i<countA; i++) {
            if (doubleStr.charAt(i) == 'b') countB++;

        }
        minB = countB;

        for (int i=1; i<str.length(); i++) {
            if (doubleStr.charAt(i-1) == 'b') countB--;
            if (doubleStr.charAt(i + countA - 1) == 'b') countB++;

            minB = Math.min(minB, countB);
        }

        System.out.println(minB);
    }
}