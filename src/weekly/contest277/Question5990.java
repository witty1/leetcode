package weekly.contest277;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/23 10:56
 */
public class Question5990 {
    public List<Integer> findLonely(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]){
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])){
                continue;
            }
            if (i - 1>=0 && nums[i -1] == nums[i] - 1){
                continue;
            }
            if (i + 1 < nums.length && nums[i+ 1] == nums[i] + 1){
                continue;
            }
            list.add(nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        new Question5990().findLonely(new int[]{75,35,59,66,69,53,37,16,60,98,11,33,3,85,59,65,59,44,34,89,72,47});
    }
}
