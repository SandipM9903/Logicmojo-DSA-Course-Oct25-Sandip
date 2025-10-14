//Using HashMap

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{i, map.get(need)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}