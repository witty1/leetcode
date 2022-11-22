/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/12
 * @Time: 16:53
 * @Description: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 1;
        }

        double res = 1.0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b = b >> 1;
        }
        return res;
    }
}
