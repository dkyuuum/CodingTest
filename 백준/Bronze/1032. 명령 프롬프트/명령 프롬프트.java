import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = Integer.parseInt(sc.nextLine());
        String answer = "";

        for (int i = 0; i < count; i++) {
            String str = sc.nextLine();
            answer = checkStr(str, answer);
        }
        System.out.println(answer);

        sc.close();
    }

    private static String checkStr(String str, String answer) {
        StringBuilder result = new StringBuilder();

        if (answer.isEmpty()) {
            return str;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != answer.charAt(i)) {
                result.append("?");
            } else {
                result.append(str.charAt(i));
            }
        }

        return result.toString();
    }
}
