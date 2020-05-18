package daily;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/5/18
 * @Time: 9:23
 * @Description: https://leetcode-cn.com/problems/two-sum/
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer integer = map.get(target - nums[i]);
            if (integer != null && integer != i) {
                return new int[]{i, integer};
            }
            map.put(nums[i], i);

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3};
        int[] ints = twoSum(nums, 6);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
