import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[] carr=br.readLine().toCharArray();
        int sum=0,half=0;
        for(int i=0;i<carr.length;i++) {
            int v=carr[i]-'0';
            if(i*2<carr.length) half+=v;
            sum+=v;
        }
        System.out.print(sum==half*2?"LUCKY":"READY");
    }
}