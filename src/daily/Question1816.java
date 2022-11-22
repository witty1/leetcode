package daily;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/truncate-sentence/
 * @since 2021/12/6 15:49
 */
public class Question1816 {
    public String truncateSentence1(String s, int k) {
        int count = 0, end = 0;
        int n = s.length();
        for (int i = 1; i <= n; i++) {
            if (i == n || s.charAt(i) == ' ') {
                end = i;
                count++;
                if (count == k) {
                    break;
                }
            }
        }
        return s.substring(0, end);
    }

    public String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(s1[i]).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
