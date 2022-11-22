package offer;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/19
 * @Time: 16:28
 * @Description: No Description
 */
public class Offer05 {
    public String replaceSpace(String s) {
        char[] array = s.toCharArray();
        int count = 0, j = 0;
        for (char c : array) {
            if (c == ' ') {
                count++;
            }
        }
        char[] chars = new char[array.length + count * 2];
        for (char c : array) {
            if (c != ' ') {
                chars[j++] = c;
            } else {
                chars[j++] = '%';
                chars[j++] = '2';
                chars[j++] = '0';
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new Offer05().replaceSpace("We are happy."));
    }
}
