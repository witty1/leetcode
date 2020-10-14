package daily;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/14
 * @Time: 9:06
 * @Description: No Description
 */
public class Question1002 {
    public List<String> commonChars(String[] A) {
        int[] word = new int[26];
        Arrays.fill(word, Integer.MAX_VALUE);
        List<String> list = new ArrayList<>();
        for (String s : A) {
            int[] now = new int[26];
            for (int j = 0; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                now[index]++;
            }
            for (int i = 0; i < 26; i++) {
                word[i] = Math.min(word[i], now[i]);
            }
        }

        for (int i = 0; i < word.length; i++) {
            for (int j = 0; j < word[i]; j++) {
                list.add(String.valueOf((char) (i + 'a')));
            }

        }
        return list;
    }
}
