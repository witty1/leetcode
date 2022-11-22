package daily;

import java.util.HashMap;
import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
 * @since 2022/2/3 10:17
 */
public class Question1414 {
    public int findMinFibonacciNumbers(int k) {
        int a = 1, b = 1, count = 0;
        while (b <= k) {
            int c = b;
            b = a + b;
            a = c;
        }
        while (k != 0) {
            if (k >= b) {
                k -= b;
            }
            int c = a;
            a = b - a;
            b = c;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        new Question1414().findMinFibonacciNumbers(1);
    }
}
