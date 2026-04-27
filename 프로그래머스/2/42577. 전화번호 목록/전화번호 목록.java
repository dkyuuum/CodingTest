import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
//         Arrays.sort(phone_book);
        
//         for (int i=0; i<phone_book.length-1; i++) {
//             if (phone_book[i+1].startsWith(phone_book[i])) {
//                 return false;
//             }
//         }
//         return true;
        
        /**
        * HashSet 사용
        **/
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                String prefix = number.substring(0, i);
                
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
        
    }
}