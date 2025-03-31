import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int nextPush = 1; 

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            while (nextPush <= num) { 
                stack.push(nextPush++);
                result.append("+\n");
            }

            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(result); 
        sc.close();
    }
}
