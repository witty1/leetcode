package interview;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/11
 * @Time: 9:55
 * @Description: https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 */
public class FirstCome {

    //第一种：通过map
    public static char firstUniqChar(String s) {
        if (s.isEmpty()){
            return ' ';
        }
        Map<Character, Integer> map = new HashMap<>(26);

        for (int i = 0; i < s.length(); i++) {
           if (map.containsKey(s.charAt(i))){
               Integer value = map.get(s.charAt(i));
               map.put(s.charAt(i), ++value);
           }else {
               map.put(s.charAt(i),1);
           }
        }
        for (int i=0;i<s.length();i++){
            if (map.get(s.charAt(i))==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //第二种：通过数组
    public static char firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            count[c-'a']++;
        }
        for (char c : array) {
            if (count[c-'a']==1){
                return c;
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar1("leetcode"));
    }
}
