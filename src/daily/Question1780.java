package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/check-if-number-is-a-sum-of-powers-of-three/
 * @since 2022/12/9 20:41
 */
public class Question1780 {
    public boolean checkPowersOfThree(int n) {
        int i = 1;
        while (i * 3 <= n){
            i *= 3;
        }
        for (; i>= 1; i /= 3) {
            if (n >= i){
                n -=i;
            }
            if (n == 0){
                return true;
            }
        }
        return false;
    }
}
