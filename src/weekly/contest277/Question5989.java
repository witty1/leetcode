package weekly.contest277;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/23 10:38
 */
public class Question5989 {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 0;
        int min = nums[0];
        int max = nums[length - 1];
        for (int num : nums) {
            if (num != min && num != max) {
                res++;
            }
        }
        return res;
    }
}
