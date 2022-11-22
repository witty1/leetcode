package daily;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/problems/simplified-fractions/
 * @since 2022/2/10 13:58
 */
public class Question1447 {
    public List<String> simplifiedFractions(int n) {
        ArrayList<String> resList = new ArrayList<>();
        if (n == 1) {
            return resList;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (existGCD(i, j) == 1) {
                    resList.add(j + "/" + i);
                }
            }

        }

        return resList;
    }

    /**
     * 辗转相除法(欧几里得算法)
     * @param x
     * @param y
     * @return
     */
    public int existGCD(int x, int y) {
        int mod = x % y;
        if (mod == 0) {
            return y;
        }
        return existGCD(y, mod);
    }

    public static void main(String[] args) {
        List<String> list = new Question1447().simplifiedFractions(4);
    }
}
