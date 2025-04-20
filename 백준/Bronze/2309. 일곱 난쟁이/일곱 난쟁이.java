import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        int i, j = 0;
        boolean done = false;

        for (i=0; i<9; i++) {
            list.add(Integer.parseInt(br.readLine()));
            sum += list.get(i);
        }
        Collections.sort(list);

        for (i=0; i<list.size(); i++) {
            for (j=i+1; j<list.size(); j++) {
                if (sum - 100 == (list.get(j) + list.get(i))) {
//                    System.out.println(list.get(i)+" "+list.get(j));
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            }
        }

        for (int k=0; k<9; k++) {
            if (k != i && k != j) {
                System.out.println(list.get(k));
            }
        }
    }
}