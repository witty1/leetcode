package q_2ckc81c;

import java.util.HashMap;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/divide-two-integers/?favorite=2ckc81c
 * @since 2022/9/16 18:07
 */
public class Top29 {
    public static int divide(int dividend, int divisor) {
        if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        //这里如果转换成正整数会有一个坑，如果除数或被除数为Integer.MIN_VALUE用-a的方式转换成正整数并不会溢出或者自动转换成Integer.MAX_VALUE，而是保持原值不变，所以统一转化为负数处理。如果用long处理则不会有问题
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int res = div(dividend, divisor);
        return sign > 0 ? res : -res;
    }

    private static int div(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int temp = divisor;
        int count = 1;
        int multiply = temp + temp;
        while (multiply < 0 && multiply >= dividend) {
            count += count;
            temp = multiply;
            multiply += multiply;
        }
        return count + div(dividend - temp, divisor);
    }

    public static void main(String[] args) {
//        System.out.println(divide(Integer.MIN_VALUE, 2));
//        System.out.println(divide(10, 3));
    }


}
