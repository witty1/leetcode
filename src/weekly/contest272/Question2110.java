package weekly.contest272;

import java.util.ArrayList;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/22 16:13
 * @description: https://leetcode-cn.com/problems/number-of-smooth-descent-periods-of-a-stock/
 */
public class Question2110 {

    public long getDescentPeriods(int[] prices) {
        long size = 0;
        long count = prices.length;
        for (int i = prices.length - 1; i > -1; i--) {
            int temp = i +1;
            if (temp < prices.length && prices[temp] == prices[i] - 1){
                count += size++;
            }else {
                size = 1;
            }
        }
        return count;
    }




    public static void main(String[] args) {
        System.out.println(new Question2110().getDescentPeriods(new int[]{7,6,5,4,3,2,1}));
    }
}
