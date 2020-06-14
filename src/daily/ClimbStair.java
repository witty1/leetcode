package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/14
 * @Time: 20:33
 * @Description: https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * 斐波那契数列 动态规划
 */
public class ClimbStair {
    public static int climbStairs(int n) {
        if (n<=2){
            return n;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 3;
        for (int i = 3; i <= n; i++) {
            f3 = f2 + f1;
            f1 = f2;
            f2 = f3;
        }

        return f3;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(6));
    }
}
