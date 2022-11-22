package daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 * @since 2022/9/12 18:23
 */
public class Question1608 {
    public int specialArray(int[] nums) {
//        nums = IntStream.of(nums)
//                .boxed()
//                .sorted(Comparator.reverseOrder())
//                .mapToInt(Integer::intValue)
//                .toArray();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= i && (i == n || nums[i] < i)) {
                return i;
            }
        }

        return -1;
    }
}
