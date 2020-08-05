package backtrack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/5
 * @Time: 9:42
 * @Description: No Description
 */
public class PowxN {
    public static double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return cal(x, n);
    }

    public static double cal(double x, int n) {
        if (n == 0) {
            return 1.0;
        } else if (n == 1) {
            return x;
        }
        double half = cal(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.1, 5));
    }
}
