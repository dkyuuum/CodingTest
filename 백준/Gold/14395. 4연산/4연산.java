import java.io .*;
import java.util .*;

public class Main {
   static class Pair {
       long num;
       String op;
       
       Pair(long num, String op) {
           this.num = num;
           this.op = op;
       }
   }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long s = Integer.parseInt(st.nextToken());
        long t = Integer.parseInt(st.nextToken());
        
        // s == t 
        if (s == t) {
            System.out.println(0);
            return;
        }
        
        // 초기화
        Queue<Pair> queue = new LinkedList<>();
        HashSet<Long> visited = new HashSet<>();
        
        queue.add(new Pair(s, ""));
        visited.add(s);
        
        while(!queue.isEmpty()) {
            Pair current = queue.poll();
            long n;
            
            n = current.num * current.num;
            if (n == t) {
                System.out.println(current.op+"*");
                return;
            }
            if (n<=1_000_000_000 && visited.add(n)) {
                queue.add(new Pair(n, current.op+"*"));
            }
            
            n = current.num + current.num;
            if (n == t) {
                System.out.println(current.op+"+");
                return;
            }
            if (n<=1_000_000_000 && visited.add(n)) {
                queue.add(new Pair(n, current.op+"+"));
            }
            
            n = current.num - current.num;
            if (n == t) {
                System.out.println(current.op+"-");
                return;
            }
            if (visited.add(n)) {
                queue.add(new Pair(n, current.op+"-"));
            }
            
            if (current.num != 0) {
                
                n = current.num / current.num;
               if (n == t) {
                    System.out.println(current.op+"/");
                    return;
                }
                if (visited.add(n)) {
                    queue.add(new Pair(n, current.op+"/"));
                }
            }
        }
                System.out.println(-1);
    }
}