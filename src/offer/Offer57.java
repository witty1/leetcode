package offer;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/31
 * @Time: 16:34
 * @Description: No Description
 */
public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        int j = nums.length - 1, i = 0;
        while (i < j) {
            int count = target - nums[j];
            if (count > nums[i]) {
                i++;
            } else if (count < nums[i]) {
                j--;
            } else {
                return new int[]{nums[i], nums[j]};
            }
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Offer57().twoSum(new int[]{14, 15, 16, 22, 53, 60}, 76)));
    }
}
