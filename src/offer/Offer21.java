package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/6
 * @Time: 14:14
 * @Description: No Description
 */
public class Offer21 {

    public int[] exchange(int[] nums) {
        int odd = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                int temp = nums[i];
                nums[i] = nums[odd];
                nums[odd++] = temp;
            }

        }
        return nums;
    }
}
