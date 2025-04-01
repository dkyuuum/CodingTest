import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        StringBuffer result = new StringBuffer();

        int count = sc.nextInt();

        int nextPush = 1;  

        for (int i = 0; i < count; i++) {
            int num = sc.nextInt();

            while (nextPush <= num) {
                stack.push(nextPush++);
                result.append("+\n");
                continue;
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                result.append("-\n");
            }
             else {        
                 System.out.println("NO"); 
                return;
             }
         }
         System.out.print(result); 
         sc.close();
    }
}
