import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String[] check = s.split("");
        
        int count = 0;
        int isPal = 0;

        for (int i=0; i<check.length/2; i++) {
            if (check[i].equals(check[check.length-i-1])) {
                isPal = 1;
            } else {
                isPal = 0;
                break;
            }
        }

        if (check.length == 1) {
            isPal = 1;
        }
        System.out.println(isPal);
    }
}
