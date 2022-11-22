package weekly.contest294;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-294
 * @since 2022/5/22 10:30
 */
public class Question294 {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (letter == s.charAt(i)) {
                count++;
            }
        }
        return (count * 100 / s.length());
    }


    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] left = new int[capacity.length];
        for (int i = 0; i < capacity.length; i++) {
            left[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(left);
        int count = 0;
        for (int value : left) {
            if (value == 0) {
                count++;
                continue;
            }
            if (additionalRocks <= 0) {
                break;
            }
            additionalRocks -= value;
            if (additionalRocks >= 0) {
                count++;
            }
        }
        return count;
    }

    public int minimumLines(int[][] stockPrices) {
        int count = 1;
        if (stockPrices.length <= 2) {
            return 1;
        }
        int x1 = stockPrices[0][0];
        int x2 = stockPrices[1][0];
        int y1 = stockPrices[0][1];
        int y2 = stockPrices[1][1];
        BigDecimal a = calA(x1, y1, x2, y2);
        int b = calB(x1, y1, a);
        for (int i = 2; i < stockPrices.length; i++) {
            int ax = a.multiply(new BigDecimal(stockPrices[i][0])).intValue();
            if (stockPrices[i][1] == ax + b) {
                continue;
            }
            x1 = stockPrices[i - 1][0];
            x2 = stockPrices[i][0];
            y1 = stockPrices[i - 1][1];
            y2 = stockPrices[i][1];
            a = calA(x1, y1, x2, y2);
            b = calB(x1, y1, a);
            count++;
        }
        // y = ax+b

        return count;
    }

    private BigDecimal calA(int x1, int y1, int x2, int y2) {
        BigDecimal z1 = new BigDecimal(y2 - y1);
        BigDecimal z2 = new BigDecimal(x2 - x1);
        return z1.divide(z2, 2);
    }

    private int calB(int x1, int y1, BigDecimal a) {
        BigDecimal bigDecimal = new BigDecimal(x1);
        BigDecimal bigDecimal1 = new BigDecimal(y1);
        return (bigDecimal1.subtract(a.multiply(bigDecimal))).intValue();
    }

    public static void main(String[] args) {
        int[][] stock = {{72, 98}, {62, 27}, {32, 7}, {71, 4}, {25, 19}, {91, 30}, {52, 73}, {10, 9}, {99, 71}, {47, 22}, {19, 30}, {80, 63}, {18, 15}, {48, 17}, {77, 16}, {46, 27}, {66, 87}, {55, 84}, {65, 38}, {30, 9}, {50, 42}, {100, 60}, {75, 73}, {98, 53}, {22, 80}, {41, 61}, {37, 47}, {95, 8}, {51, 81}, {78, 79}, {57, 95}};
        System.out.println(new Question294().minimumLines(stock));
    }
}
