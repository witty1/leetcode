package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/17
 * @Time: 10:44
 * @Description: https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * <p>
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * 示例:
 * 输入: a = 1, b = 1
 * 输出: 2
 */
public class Offer65 {
    //1100  1011
    public int add(int a, int b) {
        while (b != 0) {
            //c 进位
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Offer65().add(11, 22));
    }
}
