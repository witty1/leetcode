package q_2ckc81c;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/longest-palindromic-substring/
 * @since 2022/9/15 17:38
 */
public class Top5 {

    public static String longestPalindrome(String s) {
        //s由数字和英文字母组成，所以数组的长度为10+52
        ArrayList[] list = new ArrayList[62];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int ch = array[i];
            //0-9的ascii码为48~57，A-Z为65~90，a-z为97~122
            if (ch <= 57) {
                ch -= 48;
            }else if (ch <= 90){
                ch -= 65;
            }else {
                ch -= 97;
            }
            if (list[ch] == null) {
                list[ch] = new ArrayList<>();
            }
            list[ch].add(i);
        }
        int max = 1, begin = 0;
        for (ArrayList<Integer> subList : list) {
            if (subList == null || subList.size() == 1) {
                continue;
            }
            int left = 0, right = subList.size() - 1;
            int temp = left;
            while (right > left && subList.get(right) - subList.get(left) + 1 > max) {
                int l = subList.get(temp);
                int r = subList.get(right);
                int length = r - l + 1;
                if (length > max && judge(l, r, array)) {
                    max = length;
                    begin = l;
                }
                if (++temp == right) {
                    right--;
                    temp = left;
                }
            }
        }
        return s.substring(begin, begin + max);
    }

    private static boolean judge(int left, int right, char[] array) {
        if (left >= right) {
            return true;
        }
        if (array[left] != array[right]) {
            return false;
        }
        return judge(left + 1, right - 1, array);
    }


    public static void main(String[] args) {
//        System.out.println(longestPalindrome("bacabab"));
        System.out.println(longestPalindrome("xaabacxcabaaxcabaax"));
        System.out.println((byte)0);

    }


}
