package daily;

import java.util.HashMap;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/count-number-of-pairs-with-absolute-difference-k/
 * @since 2022/2/9 9:51
 */
public class Question2006 {
    public int countKDifference(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sub = nums[i] - nums[j];
                if (Math.abs(sub) == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public int countKDifference1(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            res += map.getOrDefault(num - k, 0) + map.getOrDefault(num + k, 0);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        new Question2006().countKDifference1(new int[]{1, 2, 2, 1}, 1);
    }
}
