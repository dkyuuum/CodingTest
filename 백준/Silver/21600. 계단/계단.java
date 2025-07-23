import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n = Integer.parseInt(br.readLine());

         StringTokenizer st = new StringTokenizer(br.readLine());
         int[] arr = new int[n];
         for (int i = 0; i < n; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
        int max = 0;

        for (int i=0; i<n; i++) {
            // 구간 길이를 1부터 최대 가능한 길이까지 늘려가며 검사
            for (int j=1; i+j<=n; j++) {
                boolean isStep = true;
                for (int k = 0; k<j; k++) {
                    if (arr[i + k] < k + 1) { // 칸 높이 조건 검사
                        isStep = false;
                        break;
                    }
                }
                if (isStep) {
                    max = Math.max(max, j);
                } else {
                    break; // 길이 늘릴수록 조건 못맞추면 더 이상 확인하지 않아도 됨
                }
            }
        }

        System.out.println(max);

    }
}
