package daily;

import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/12/13 11:03
 */
public class Question1832 {
    public boolean checkIfPangram(String sentence) {
        int[] cnt = new int[26];
        for (char c : sentence.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i : cnt) {
            if (i == 0){
                return false;
            }
        }
        return true;
    }
}
