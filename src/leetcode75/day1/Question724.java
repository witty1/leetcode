package leetcode75.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/find-pivot-index/
 * @since 2022/6/29 20:42
 */
public class Question724 {
    public int pivotIndex(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int leftCount = 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int rightCount = 0;
        for (int i = 0; i < nums.length; i++) {
            leftCount += nums[i];
            left[i] = leftCount;
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            rightCount += nums[j];
            right[j] = rightCount;
        }
        if (right[1] == 0) {
            return 0;
        }
        for (int i = 1; i + 1 < left.length; i++) {

            if (left[i - 1] == right[i + 1]) {
                return i;
            }

        }
        if (left.length - 2 >= 0 && left[left.length - 2] == 0) {
            return left.length - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Question724 question724 = new Question724();
        System.out.println(question724.pivotIndex(new int[]{-1, -1, -1, 1, 1, 1}));
    }
}
