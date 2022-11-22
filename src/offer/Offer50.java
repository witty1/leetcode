package offer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/19
 * @Time: 16:39
 * @Description: No Description
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        char[] array = s.toCharArray();
        int[] count = new int[26];
        for (char c : array) {
            count[c - 'a']++;
        }
        for (char c : array) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Offer50().firstUniqChar("cc"));
    }
}
