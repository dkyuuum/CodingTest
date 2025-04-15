import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "");
        String word = st.nextToken();

        Set<String> set = new HashSet<>();
        Collections.addAll(set, word);

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length()+1; j++) {
                set.add(word.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}