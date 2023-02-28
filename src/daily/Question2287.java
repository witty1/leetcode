package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/rearrange-characters-to-make-target-string/
 * @since 2023/1/13 10:01
 */
public class Question2287 {
    public int rearrangeCharacters(String s, String target) {
        int[] sourceCnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sourceCnt[s.charAt(i) - 'a']++;
        }
        int[] targetCnt = new int[26];
        for (int i = 0; i < target.length(); i++) {
            targetCnt[target.charAt(i) - 'a']++;
        }
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < targetCnt.length; i++) {
            if (targetCnt[i] > 0){
                int left = sourceCnt[i] / targetCnt[i];
                if (left == 0){
                    return 0;
                }
                max = Math.min(max, left);
            }
        }
        return max;
    }
}
