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
 * @since 2021/8/29 12:15
 */
public class Leetcode1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int length = arr.length;
        int nextLen = 1;
        while (nextLen <= length) {
            for (int i = 0; i + nextLen <= length; i++) {
                sum = recur(i, i + nextLen, sum, arr);
            }
            nextLen += 2;
        }
        return sum;
    }

    public int recur(int left, int right, int sum, int[] arr) {
        for (int i = left; i < right; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public int sumOddLengthSubarrays1(int[] arr) {
//        ThreadLocal.
        int sum = 0;
        int length = arr.length;
        int nextLen = 1;
        int[] prefixCount = new int[arr.length + 1];
        for (int i = 1; i < prefixCount.length; i++) {
            prefixCount[i] = arr[i - 1] + prefixCount[i - 1];
        }
        while (nextLen <= length) {
            for (int i = 0; i + nextLen <= length; i++) {
                sum += prefixCount[i + nextLen] - prefixCount[i];
            }
            nextLen += 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        final Leetcode1588 l = new Leetcode1588();
        System.out.println(l.sumOddLengthSubarrays1(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
