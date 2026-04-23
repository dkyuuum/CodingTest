import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        
        int len = nums.length;
        int available = len / 2;
        
        for (int i=0; i<len; i++) {
            set.add(nums[i]);
        }
        
        return set.size() > available ? available : set.size();
    }
}