package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/25
 * @Time: 11:33
 * @Description: https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * <p>
 * 剑指 Offer 58 - II. 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制：
 * 1 <= k < s.length <= 10000
 */
public class Offer58_II {
    public String reverseLeftWords(String s, int n) {
        if (n < 0 || n >= s.length()) {
            return s;
        }
        char[] t = new char[n];
        char[] c = s.toCharArray();
        System.arraycopy(c, 0, t, 0, n);
        System.arraycopy(c, n, c, 0, c.length - n);
        System.arraycopy(t, 0, c, c.length - n, t.length);
        return String.valueOf(c);
    }

    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
