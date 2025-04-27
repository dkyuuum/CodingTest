import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        Arrays.sort(arr);

        int min = 0;
        int result = 0;

        while(min <= max) {
            int mid = (min+max) / 2;
            long sum = 0;

            for (int i=0; i<arr.length; i++) {
                if (arr[i] > mid) { // 나무의 높이가 중간 길이보다 클 때
                    sum += arr[i]-mid; // 자른다
                }
            }

            if (sum >= M) {
                result = mid;
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        System.out.println(result);

    }
}