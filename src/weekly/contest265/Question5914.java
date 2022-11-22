/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package weekly.contest265;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/31 10:56
 * @description: https://leetcode-cn.com/contest/weekly-contest-265/problems/smallest-index-with-equal-value/
 */
public class Question5914 {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int mod = i % 10;
            System.out.println(mod);
            if (mod == nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Question5914().smallestEqual(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
    }
}
