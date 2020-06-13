package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/13
 * @Time: 9:58
 * @Description: https://leetcode-cn.com/problems/move-zeroes/
 *
 * 思路：双指针，把非0元素交换到前面
 */
public class MoveZero {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] num = {0, 0, 3};
        moveZeroes(num);
    }
}
