import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashMap<Integer, Boolean> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], false);
        }
        for (int key : hm.keySet()) {
            if (hm.containsKey(key - 1) == false) {
                hm.put(key, true);
            }
        }

        int max = 0;
        for (int key : hm.keySet()) {
            if (hm.get(key) == true) {
                int k = 1;
                
                while (hm.containsKey(key + k)) {
                    k++;
                }
                
                if (k > max) {
                    max = k;
                }
            }
        }

        return max;
    }
}