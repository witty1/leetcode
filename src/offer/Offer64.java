package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/25
 * @Time: 11:58
 * @Description: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 剑指 Offer 64. 求1+2+…+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * 输入: n = 3
 * 输出: 6
 * <p>
 * 示例 2：
 * 输入: n = 9
 * 输出: 45
 * <p>
 * 限制：
 * 1 <= n <= 10000
 */
public class Offer64 {

    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
