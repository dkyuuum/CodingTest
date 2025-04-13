import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);

        int M = sc.nextInt();
        for (int j = 0; j < M; j++) {
            int target = sc.nextInt();
            if (binarySearch(A, target) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Boolean> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            map.put(Integer.parseInt(st.nextToken()), false);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (map.containsKey(target)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}