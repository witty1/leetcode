/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package interview;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/23 18:25
 * https://leetcode-cn.com/problems/check-permutation-lcci/
 */
public class CheckPermutationlcci {

    /**
     * 本质就是判断两个字符串的字符以及字符数是否一致，用stream处理的效率较低
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
//            map1.compute(s1.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
//            map2.compute(s2.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);

        }
        Set<Character> set = map1.keySet();
        for (Character character : set) {
            if (!map1.getOrDefault(character, 0).equals(map2.get(character))) {
                return false;
            }
        }
        return true;
//        Character character = map1.keySet()
//                .stream()
//                .filter(k -> !map1.getOrDefault(k, 0).equals(map2.get(k)))
//                .findAny()
//                .orElse(null);
//        return character == null;

    }

    /**
     * 将两个字符串排序后进行比较
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation1(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        char[] a1 = s1.toCharArray();
        Arrays.sort(a1);
        char[] a2 = s2.toCharArray();
        Arrays.sort(a2);
        return new String(a1).equals(new String(a2));
    }

    /**
     * 桶计数，本质还是统计字符个数
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean CheckPermutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.length() == 0) {
            return true;
        }
        int[] n1 = new int[26], n2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            n1[s1.charAt(i) - 'a']++;
            n2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n1.length; i++) {
            if (n1[i] != n2[i]){
                return false;
            }
        }
        return true;
    }
    

}
