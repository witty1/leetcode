package daily;

import java.util.HashMap;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/largest-substring-between-two-equal-characters/
 * @since 2022/9/17 10:41
 */
public class Question1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int ans = -1;
        Integer[] cnt = new Integer[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (cnt[index] != null){
                ans = Math.max(ans, i - cnt[index] - 1);
            }else {
                cnt[index] = i;
            }
        }
        return ans;
    }
}
