package weekly.contest275;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/9 10:48
 * @description: https://leetcode-cn.com/contest/weekly-contest-275/problems/minimum-swaps-to-group-all-1s-together-ii/
 */
public class Question5977 {
    public int minSwaps(int[] nums) {
        int blankCount = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == 1 && nums[i - 1] == 0 && nums[i+1] == 0){
                blankCount++;
            }
        }
        return 0;
    }
}
