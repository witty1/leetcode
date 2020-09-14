package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/14
 * @Time: 13:57
 * @Description: https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Interview8 {
    public static int myAtoi1(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int index = 0, res = 0, flag = 1;
        while (index < str.length() && str.charAt(index) == ' ') {
            ++index;
        }
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            flag = str.charAt(index++) == '+' ? 1 : -1;
        }
        while (index < str.length()) {
            int num = str.charAt(index) - '0';
            if (num < 0 || num > 9) {
                break;
            }
            if (flag == -1 && ((-res < Integer.MIN_VALUE / 10) || (-res == Integer.MIN_VALUE / 10 && -num < -8))) {
                return Integer.MIN_VALUE;
            }
            if (flag == 1 && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && num > 7))) {
                return Integer.MAX_VALUE;
            }
            res = res * 10 + num;
            ++index;
        }
        return flag == -1 ? -res : res;
    }

    public static int myAtoi(String str) {
        int res = 0;
        boolean used = false;
        boolean flag = false;
        boolean num = false;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //判断是否是有效数字
            if (chars[i] < 48 || chars[i] > 57) {
                if (chars[i] == 45 && !used && !num) {
                    used = true;
                    flag = true;
                    continue;
                } else if (chars[i] == 43 && !used && !num) {
                    used = true;
                    continue;
                } else if (chars[i] == 32 && res == 0 && !used && !num) {
                    continue;
                } else {
                    break;
                }
            }
            num = true;
            int unit = Character.getNumericValue(chars[i]);
            if (flag && ((-res < Integer.MIN_VALUE / 10) || (-res == Integer.MIN_VALUE / 10 && -unit < -8))) {
                return Integer.MIN_VALUE;
            }
            if (!flag && ((res > Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && unit > 7))) {
                return Integer.MAX_VALUE;
            }
            res = res * 10 + unit;

        }
        return flag ? -res : res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi1(" "));
    }
}
