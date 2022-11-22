package daily;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/
 * @since 2022/2/11 9:57
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 * <p>
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 * <p>
 * 返回可能的 最小差值 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * [1,3,5,7,345,32523,641,672,2]
 * 5
 * 输出：6
 */
public class Question1984 {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1 || nums.length <= 1) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i + k <= nums.length; i++) {
            res = Math.min(res, nums[i + k - 1] - nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        new Question1984().minimumDifference(new int[]{1, 3, 5, 7, 345, 32523, 641, 672, 2}, 5);
    }
}
