package daily;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @since 2022/1/31 18:16
 */
public class Question1342 {
    public int numberOfSteps(int num) {
        int res = 0;
        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            res++;
        }
        return res;
    }

    public int numberOfSteps1(int num) {

        return num == 0 ? 0 : (getLoc(num) + getCnt(num) - 1);
    }

    public int getLoc(int num) {
        for (int i = 31; i >= 0; i--) {
            if ((num >> i & 1) == 1) {
                return i + 1;
            }
        }
        return 0;
    }

    public int getCnt(int num) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((num >> i & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }
}
