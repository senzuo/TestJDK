package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 申卓 on 2017/8/14.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target-nums[i])){
                int index = map.get(target-nums[i]);
                return new int[]{index,i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}
