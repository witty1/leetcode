package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/8
 * @Time: 9:45
 * @Description: https://leetcode-cn.com/problems/reverse-string/
 */
public class Question344 {
    public void reverseString(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < s.length && i<j; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j--] = temp;
        }
    }
}
