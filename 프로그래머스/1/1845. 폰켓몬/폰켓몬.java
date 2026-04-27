import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int len = nums.length;
        int can = len / 2;
        
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        /**
        * 최대 몇 종류인지 고르는 문제
        * map의 사이즈만으로 가능!
        **/
        if (map.size() > can) {
            answer = can;
        } else {
            answer = map.size();
        }
        
        return answer;
    }
}