package topInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/12
 * @Time: 13:42
 * @Description: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
@SuppressWarnings("all")
public class Interview3 {
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int max = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
          if (map.containsKey(s.charAt(i))){
              left = Math.max(left,map.get(s.charAt(i)));
          }
          map.put(s.charAt(i),i);
          max = Math.max(max, i-left+1);

        }
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>(s.length());
        int max = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (!map.containsKey(key)) {
                map.put(key, i);
            } else {

                max = Math.max(len, max);
                i = map.get(key);
                map.clear();
            }
            len = map.size();
        }
        return Math.max(len, max);

    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcdefghijklmnopqrstuvwxyz"));
    }
}
