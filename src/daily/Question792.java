package daily;

import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/number-of-matching-subsequences/
 * @since 2022/11/17 20:46
 */
public class Question792 {
    //timeout
    public int numMatchingSubseq1(String s, String[] words) {
        int ans = 0;
        char[] sourceArray = s.toCharArray();
        for (String word : words) {
            char[] aimArray = word.toCharArray();
            int j = 0;
            for (int i = 0; i < sourceArray.length - (aimArray.length - j); i++) {
                if (sourceArray[i] == aimArray[j] && ++j == aimArray.length) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        char[] sourceArray = s.toCharArray();
        byte[] count = new byte[26];
        for (char c : sourceArray) {
            count[c - 'a'] = 1;
        }
        for (String word : words) {
            if (word.length() > s.length()){
                continue;
            }
            char[] aimArray = word.toCharArray();
            int x = 0, y = aimArray.length - 1;
            for (int i = 0, j = sourceArray.length - 1; i <= j; i++, j--) {
                if (count[aimArray[x] - 'a'] == 0 || count[aimArray[y] - 'a'] == 0) {
                    break;
                }
                if (aimArray[x] == sourceArray[i]) {
                    x++;
                }
                if (aimArray[y] == sourceArray[j]) {
                    y--;
                }
                if (x > y) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
