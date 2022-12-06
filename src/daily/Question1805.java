package daily;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/number-of-different-integers-in-a-string/
 * @since 2022/12/6 16:52
 */
public class Question1805 {
    public int numDifferentIntegers(String word) {
        HashSet<String> set = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9'){
                    temp.append(word.charAt(i));
            }else {
                if (temp.length() > 0){
                    add(set, temp);
                    temp = new StringBuilder();
                }
            }
        }
        if (temp.length() > 0){
            add(set, temp);
        }
        return set.size();
    }

    public void add(Set<String> set, StringBuilder temp){
        while (temp.length() > 1 && temp.charAt(0) == '0'){
            temp.deleteCharAt(0);
        }
        set.add(temp.toString());
    }

    public int numDifferentIntegers1(String word) {
        HashSet<String> set = new HashSet<>();
        int pre, i = 0;
        int length = word.length();
        while (true){
            while (i < length &&!Character.isDigit(word.charAt(i))){
                i++;
            }
            if (i == length){
                break;
            }
            pre = i;
            while (i < length && Character.isDigit(word.charAt(i))){
                i++;
            }
            while (i - pre > 1 && word.charAt(pre) == '0'){
                pre++;
            }
            set.add(word.substring(pre, i));
        }
        return set.size();
    }

    public static void main(String[] args) {
        String s1 = "123";
        String s2 = "12";
        System.out.println(s1.compareTo(s2));
        Question1805 question1805 = new Question1805();
        System.out.println(question1805.numDifferentIntegers("a1b01c001"));
    }
}
