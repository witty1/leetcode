package weekly.contest269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/11/28 11:02
 * @description: https://leetcode-cn.com/contest/weekly-contest-269/problems/find-target-indices-after-sorting-array/
 */
public class Question5938 {

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                res.add(i);
            }
        }
        return res;
    }

}
