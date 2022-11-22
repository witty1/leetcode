

package primary;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/9/20 11:31
 * https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int pre = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != pre){
                nums[count++] = nums[i];
                pre = nums[i];
            }
        }
        return count;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0 ){
            return 0;
        }
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]){
                nums[++left] = nums[right];
            }
        }
        return ++left;
    }
}
