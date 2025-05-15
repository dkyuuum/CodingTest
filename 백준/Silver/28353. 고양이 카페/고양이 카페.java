import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 고양이 n마리~
        int k = Integer.parseInt(st.nextToken()); // 고양이 들 수 있는 최대 무게

        int[] weight = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken()); // 각각 고양이 몸무게
        }

        Arrays.sort(weight); // 고양이 무게 정렬

        int count = 0;
        int left = 0; // 젤 가벼운 고양이
        int right = n-1; // 젤 무거운 고양이
        for (left = 0; left <= right;) {
            if (weight[left] + weight[right] <= k && left != right) {
                count++;
                left++;
            }
            right--;
        }

        System.out.println(count);
    }
}
