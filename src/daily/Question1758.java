package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/
 * @since 2022/11/29 10:21
 */
public class Question1758 {
    // 1 1 1 1
    // 0 1 1 1
    // 1 0 1 1 1 0
    public int minOperations(String s) {
        int ans = 0;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]){
                array[i] = array[i] == '0' ? '1' : '0';
                ans++;
            }
        }
        return Math.min(ans, s.length() - ans);
    }
}
