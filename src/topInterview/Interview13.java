package topInterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/15
 * @Time: 14:44
 * @Description: https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Interview13 {
    private static int convert(Character c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }

    }

    public static int romanToInt1(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int next = 0;
            int pre = convert(s.charAt(i));
            if (i + 1 < s.length() && (next = convert(s.charAt(i + 1))) > pre) {
                res += (next-pre);
                i++;
            } else {
                res += pre;
            }
        }
        return res;
    }


    public static int romanToInt(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for (int i = 0; i < s.length(); i++) {
            Integer t = map.get(s.charAt(i));
            Integer integer = null;
            if (i + 1 < s.length()) {
                integer = map.get(s.charAt(i + 1));
            }
            if (integer != null && integer > t) {
                res += (integer - t);
                i++;
            } else {
                res += t;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt1("MCMXCIV"));
    }
}
