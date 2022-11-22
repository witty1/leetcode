/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package dataStructure;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/7/25 9:36
 * @Description: https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Leetcode53 {

    public int maxSubArray(int[] nums) {
        int pre = 0,maxCount = nums[0];
        for (int num : nums) {
            //如果前面的元素加上当前元素还比当前元素小，则直接丢弃原来的元素
            pre = Math.max(num + pre, num);
            //比较最大值是否小于最新值，小于则更新当前子序和的最大值
            maxCount = Math.max(pre, maxCount);
        }
        return maxCount;
    }
}
