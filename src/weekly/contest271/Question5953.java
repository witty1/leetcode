package weekly.contest271;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-271/problems/sum-of-subarray-ranges/
 * @since 2021/12/12 10:46
 */
public class Question5953 {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                res = max - min + res;
            }

        }
        return res;
    }

}
