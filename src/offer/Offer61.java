package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/21
 * @Time: 16:48
 * @Description: No Description
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
//        for (int num : nums) {
//            if (num != 0) {
//                if (set.contains(num)) {
//                    return false;
//                }
//                max = Math.max(max, num);
//                min = Math.min(min, num);
//                set.add(num);
//            }
//        }
//        return max - min < 5;
        Arrays.sort(nums);
        int zero = 0;
        for (int i = 0; i < 4; i++) {
            if (nums[i]==0){
                zero++;
            }else if (nums[i] == nums[i+1]){
                return false;
            }

        }
        return nums[4] - nums[zero] < 5;
    }
}
