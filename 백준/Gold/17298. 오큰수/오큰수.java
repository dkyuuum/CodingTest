import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
//        StringBuilder sb = new StringBuilder();
        int[] rslt = new int[N];

        rslt[N-1] = -1;
        stack.push(arr[N - 1]);

        for (int i = N-2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            rslt[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int r : rslt) {
            sb.append(r).append(" ");
        }

        System.out.println(sb);
    }
}