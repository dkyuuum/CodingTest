import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] honey = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            honey[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefix = new int[n];
        int max = Integer.MIN_VALUE;
        prefix[0] = honey[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1] + honey[i];
        }

        // 벌 벌 벌통
        for(int i = 1; i < n - 1; i++){
            int sum = (prefix[n-1] - honey[0] - honey[i]) + (prefix[n-1] - prefix[i]);
            max = Math.max(sum, max);
        }

        // 벌통 벌 벌
        for(int i = 1; i < n - 1; i++){
            int sum = (prefix[n-2] - honey[i]) + prefix[i-1];
            max = Math.max(sum, max);
        }

        // 벌 벌통 벌
        for(int i = 1; i < n - 1; i++){
            int sum = prefix[i] + (prefix[n-2] - prefix[i-1]) - honey[0];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}