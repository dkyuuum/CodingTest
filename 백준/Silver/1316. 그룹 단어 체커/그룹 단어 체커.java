import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;

        while (num-- > 0) {
            String s = sc.next();
            boolean isGroupWord = true;

            for (int i = 0; i < s.length() - 1; i++) {
                char current = s.charAt(i);
                char next = s.charAt(i + 1);

                if (current != next && s.substring(i + 1).contains(String.valueOf(current))) {
                    isGroupWord = false;
                    break;
                }
            }

            if (isGroupWord) count++;
        }
        System.out.println(count);
    }
}
