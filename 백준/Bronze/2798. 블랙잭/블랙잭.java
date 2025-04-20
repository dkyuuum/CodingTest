import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

        for (int i=0 ;i<num; i++) {
            list.add(Integer.parseInt(st2.nextToken()));
        }

//        int min = 999; // max(M)와 세 카드 합의 차이
        int answer = 0;
        for (int i=0 ;i<num; i++) {
            for (int j=i+1 ;j<num;j++) {
                for (int k=j+1 ;k<num;k++) {
                    int d = list.get(i) + list.get(j) + list.get(k);

                    if (d > answer && d <= max) {
//                        min = max - d;
                        answer = d;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}