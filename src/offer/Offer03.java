package offer;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/5
 * @Time: 14:30
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Offer03 {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    public static int find(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public int findRepeatNumber3(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return 0;
    }

    public int findRepeatNumber4(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                return pre;
            }
            pre = nums[i];
        }
        return 0;
    }

    public int findRepeatNumber5(int[] nums) {
        int[] count = new int[nums.length];
        for (int num : nums) {
            if (count[num] > 0) {
                return num;
            }
            count[num]++;
        }
        return 0;
    }

    public static int findRepeatNumber6(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                int temp = nums[i];
                if (temp != i && nums[temp] == temp) {
                    return temp;
                }
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        findRepeatNumber6(nums);
    }
}
