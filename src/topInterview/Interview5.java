package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/13
 * @Time: 14:38
 * @Description: https://leetcode-cn.com/problems/reverse-integer/
 */
public class Interview5 {
    public static int reverse1(int x) {
        int res = 0;
        while (x != 0) {
            int unit = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && unit > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && unit < -8)) {
                return 0;
            }
            res = res * 10 + unit;
            x /= 10;
        }
        return res;
    }

    public static int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(Math.abs(x)));
        int res = 0;
        sb = sb.reverse();
        if (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.delete(0, 1);
        }
        if (x < 0) {
            sb.insert(0, '-');
        }
        try {
            res = Integer.parseInt(sb.toString());
        } catch (Exception e) {

        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(reverse1(-0));
    }
}
