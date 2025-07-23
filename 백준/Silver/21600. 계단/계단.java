import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp=new int[n];
        Arrays.fill(dp, 1);
        for(int i=1;i<n;i++){
            if(dp[i-1]+1<=arr[i]){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=arr[i];
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }

        System.out.println(max);
    }
}