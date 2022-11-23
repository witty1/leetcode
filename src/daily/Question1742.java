package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/description/
 * @since 2022/11/23 9:30
 */
public class Question1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int ans = 0;
        int[] cnts = new int[46];
        for (int i = lowLimit; i < highLimit + 1; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            cnts[sum]++;
            ans = Math.max(ans, cnts[sum]);
        }
        return ans;
    }

}
