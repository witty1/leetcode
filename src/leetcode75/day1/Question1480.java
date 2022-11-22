package leetcode75.day1;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/running-sum-of-1d-array/
 * @since 2022/6/29 20:40
 */
public class Question1480 {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            res[i] = count;
        }
        return res;
    }
}
