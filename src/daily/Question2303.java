package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/calculate-amount-paid-in-taxes/
 * @since 2023/1/23 13:58
 */
public class Question2303 {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0;
        for (int i = 0; i < brackets.length && income > 0; i++) {
            int total = Math.min(brackets[i][0], income);
            if (i > 0) {
                if (brackets[i - 1][0] > income) {
                    break;
                }
                total -= brackets[i - 1][0];
            }
            ans += total * brackets[i][1] ;
        }

        return ans * 0.01;
    }

    public static void main(String[] args) {
        System.out.println(1675 % 7);
        Question2303 question2303 = new Question2303();
        question2303.calculateTax(new int[][]{{3, 50}, {7, 10}, {12, 25}}, 10);
        
    }
}
