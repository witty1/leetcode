package weekly.contest324;

import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-324/
 * @since 2022/12/25 10:05
 */
public class Question324 {
    public int similarPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            HashSet<Character> set1 = new HashSet<>();
            char[] a = words[i].toCharArray();
            for (char c : a) {
                set1.add(c);
            }
            for (int j = i + 1; j < words.length; j++) {
                boolean flag = true;
                HashSet<Character> set2 = new HashSet<>();
                char[] chars = words[j].toCharArray();
                int k = 0;
                for (; k < chars.length; k++) {
                    if (!set1.contains(chars[k])) {
                        flag = false;
                        break;
                    }
                    set2.add(chars[k]);
                }
                if (flag && set1.size() == set2.size()) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question324 question324 = new Question324();
        question324.similarPairs(new String[]{"aba", "aabb", "abcd", "bac", "aabc"});
    }
}
