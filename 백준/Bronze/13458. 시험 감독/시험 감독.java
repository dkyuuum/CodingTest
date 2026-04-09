import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());         // N개의 시험장

        // i번 시험장의 A명 응시자
        int[] p = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<N; i++) {
            p[i] = Integer.parseInt(st.nextToken());   
        }

        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());       // 총감독관 최대 B명  
        int C = Integer.parseInt(st.nextToken());       // 부감독관 최대 C명

        // 총감독관 > 시험장마다 필수 1명
        long count = 0; 

        for (int i=0; i<N; i++) {
            int temp = p[i] - B;            // 응시자 - 총감독관 관리수 = 부감독관이 관리해야하는 응시자 수 
            count++;

            if (temp > 0) {
                int t = (temp / C);
                if (temp % C != 0) t++;

                count += t;
            }
        }
        System.out.println(count);
    }
}
