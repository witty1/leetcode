/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package leetcode;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/7/27 11:23
 * https://leetcode-cn.com/problems/remove-element/
 */
public class Leetcode27 {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public int removeElement1(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right){
            if (nums[left] == val){
                nums[left] = nums[right--];
            }else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        new Leetcode27().removeElement1(new int[]{3,2,2,3},3);
    }
}
