package weekly.contest273;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-273/problems/a-number-after-a-double-reversal/
 * @since 2021/12/26 10:33
 */
public class Question5963 {
    public boolean isSameAfterReversals(int num) {
        int res = 0;
        int temp = num;
        while (temp > 0) {
            int i = temp % 10;
            res = res * 10 + i;
            temp /= 10;
        }

        System.out.println(res);
        int reverse = 0;
        while (res > 0){
            int i = res % 10;
            reverse = reverse * 10 + i;
            res /= 10;
        }

        System.out.println(reverse);
        return num == reverse;
    }

    public static void main(String[] args) {
        System.out.println(new Question5963().isSameAfterReversals(526));
    }
}
