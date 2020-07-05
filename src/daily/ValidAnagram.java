package daily;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/5
 * @Time: 9:15
 * @Description: https://leetcode-cn.com/problems/valid-anagram/description/
 */
public class ValidAnagram {
    public static boolean isAnagram2(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        int[] num = new int[26];
        for (int i=0;i<s.length();i++){
            num[s.charAt(i)-'a']++;
            num[t.charAt(i)-'a']--;
        }
        for (int i : num) {
            if (i!=0)
                return false;
        }
        return true;
    }

    public static boolean isAnagram1(String s, String t){
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }
    public static boolean isAnagram(String s, String t){
        if (s.length()!=t.length()){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                Integer integer = map.get(c);
                map.put(c,++integer);
            }else {
                map.put(c,1);
            }
        }
        for (int i=0;i<t.length();i++){
            if (map.containsKey(t.charAt(i))){
                Integer integer = map.get(t.charAt(i));
                if (integer == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), --integer);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }



    public static void main(String[] args) {
        System.out.println(isAnagram2("anagram", "nagaram"));
        System.out.println(isAnagram2("aaa", "a"));
        System.out.println(isAnagram2("a", "aa"));
    }
}
