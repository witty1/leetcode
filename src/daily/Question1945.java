package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/sum-of-digits-of-string-after-convert/
 * @since 2022/12/15 10:07
 */
public class Question1945 {
    public int getLucky(String s, int k) {
        int ans = 0;
        for (char c : s.toCharArray()) {
            int num = c - 'a' + 1;
            ans += num % 10 + num / 10;
        }
        while (--k > 0) {
            int temp = 0;
            while (ans > 0) {
                temp += ans % 10;
                ans /= 10;
            }
            ans = temp;
        }

        return ans;
    }


}
