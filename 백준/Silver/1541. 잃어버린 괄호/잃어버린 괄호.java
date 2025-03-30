import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] arr = str.split("\\-");

        int answer = 0;
        answer = sum(arr[0]);
        for (int i=1; i<arr.length; i++) {
            answer -= sum(arr[i]);
        }

        System.out.println(answer);

    }
    private static int sum(String num) {
        String[] numbers = num.split("\\+"); 
        int total = 0;

        for (String n : numbers) {
            total += Integer.parseInt(n);
        }
        
        return total;
    }
}
