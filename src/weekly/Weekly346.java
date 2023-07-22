package weekly;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-346/
 * @since 2023/5/21 10:31
 */
public class Weekly346 {
    public int minLength1(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            boolean flag = true;

            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == 'A') {
                    if (i + 1 < sb.length() && sb.charAt(i + 1) == 'B') {
                        sb.delete(i, i + 2);
                        flag = false;
//                        i--;
                        continue;
                    }
                }
                if (sb.charAt(i) == 'C') {
                    if (i + 1 < sb.length() && sb.charAt(i + 1) == 'D') {

                        sb.delete(i, i + 2);
//                        i--;
                        flag = false;
                    }
                }

            }
            if (flag) {
                break;
            }
        }

        return sb.length();
    }

    public int minLength(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            boolean add = true;
            if (s.charAt(i) == 'B') {
                if (!deque.isEmpty() && deque.peekLast() == 'A'){
                    deque.pollLast();
                    add = false;
                }
            }
            if (s.charAt(i) == 'D') {
                if (!deque.isEmpty() && deque.peekLast() == 'C') {
                    add = false;
                    deque.pollLast();
                }
            }
            if (add) {
                deque.addLast(s.charAt(i));
            }
        }
        return deque.size();
    }

    public String makeSmallestPalindrome1(String s) {
        int l = 0, r = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        StringBuilder last = new StringBuilder();
        while (l <= r) {
            char c = s.charAt(l);
            char c1 = s.charAt(r);
            if (c != c1) {
                c = c < c1 ? c : c1;
            }
            sb.append(c);
            if (l != r) {
                last.append(c);
            }
            l++;
            r--;
        }
        sb.append(last.reverse());
        return sb.toString();
    }

    public String makeSmallestPalindrome(String s) {
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length / 2 + 1; i++) {
            int j = array.length - i - 1;
            if (array[i] > array[j]) {
                array[i] = array[j];
            } else {
                array[j] = array[i];
            }
        }
        return new String(array);
    }

    public int punishmentNumber(int n) {
        int ans = 0;
        int num = 1;
        while (num++ <= n) {
            int sum = num * num;
            int judge = judge(sum, num);
            if (judge != -1) {
                ans += judge;
            }
        }
//        1 4 9 16 25 36 49 64 81 100 121
        return ans;
    }

    private int judge(int sum, int n) {
        String str = String.valueOf(sum);
        char[] cnt = str.toCharArray();
        int num = 0;
        int i = 0;
//        12694239
        // 1 2694239
        //12 694239
        //126 94239
        //1269 4239
        //12694 239
        while (i < str.length()) {

        }
        return -1;
    }

//    private boolean merge(char[] num, int i, int n){
//
//    }

    public static void main(String[] args) {
        Weekly346 weekly346 = new Weekly346();
//        System.out.println(weekly346.minLength("CCDDLLDW"));
        String seven = weekly346.makeSmallestPalindrome("seven");
        System.out.println(seven);
    }
}
