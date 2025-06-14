import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int count = 0;

        for (int k = 0; k < N; k++) {
            int find = num[k]; 
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == k) {
                    left++;
                    continue;
                } else if (right == k) {
                    right--;
                    continue;
                }

                int sum = num[left] + num[right];

                if (sum == find) {
                    count++;
                    break;
                } else if (sum < find) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}