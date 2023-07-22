package daily;

import com.sun.org.apache.regexp.internal.REUtil;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/check-if-word-is-valid-after-substitutions/
 * @since 2023/5/3 14:56
 */
public class Question1003 {

    public boolean isValid(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            int length = stringBuilder.length();
            if (length >= 3 && "abc".equals(stringBuilder.substring(length - 3, length))){
                stringBuilder.delete(length -3, length);
            }
        }
        return stringBuilder.length() == 0;
    }

    public static void main(String[] args) {
        Locale us = Locale.US;
        System.out.println(us);
        String str = "中";
        System.out.println(str.toCharArray().length);
        System.out.println(str.getBytes(StandardCharsets.UTF_8).length);
        Question1003 question1003 = new Question1003();
//        System.out.println(question1003.isValid("abcabcababcc"));
    }
}
