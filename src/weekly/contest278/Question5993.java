package weekly.contest278;

import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/30 10:31
 */
public class Question5993 {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int val = 0;
        while (set.contains(original)) {
            original <<= 1;
            val = original;
        }
        return val;
    }
}
