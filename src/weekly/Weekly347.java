package weekly;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-347
 * @since 2023/5/28 10:27
 */
public class Weekly347 {
    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);
        for (int length = sb.length() - 1; length > 0; length--) {
            if (sb.charAt(length) == '0') {
                sb.deleteCharAt(length);
            } else {
                break;
            }
        }
        return sb.toString();
    }


    public int[][] differenceOfDistinctValues(int[][] grid) {
        int[][] answer = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {
                HashSet<Integer> top = new HashSet<>();
                HashSet<Integer> bottom = new HashSet<>();
                find(grid, i, j, top, true);
                find(grid, i, j, bottom, false);
                answer[i][j] = Math.abs(top.size() - bottom.size());
            }
        }

        return answer;
    }

    public void find(int[][] grid, int x, int y, HashSet<Integer> set, boolean direction) {
        if (direction) {
            int a = x - 1;
            int b = y - 1;
            if (a < 0 || b < 0) {
                return;
            }
            set.add(grid[a][b]);
            find(grid, a, b, set, true);
        } else {
            int a = x + 1;
            int b = y + 1;
            if (a >= grid.length || b >= grid[0].length){
                return;
            }
            set.add(grid[a][b]);
            find(grid, a, b, set, false);

        }
    }


    public long minimumCost(String s) {
        char[] array = s.toCharArray();
        long ans = 0L;
        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                ans += Math.min(i, array.length - i);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("1200");
        BigDecimal i = new BigDecimal("0.0125");
//        BigDecimal n = new BigDecimal("12");
        BigDecimal pow = (i.add(BigDecimal.ONE)).pow(12);
//        BigDecimal pow1 = new BigDecimal(pow.toPlainString());
        BigDecimal multiply = pow.multiply(a).multiply(i);
        BigDecimal subtract = pow.subtract(BigDecimal.ONE);
        BigDecimal divide = multiply.divide(subtract, RoundingMode.HALF_UP);
        System.out.println(divide);

        Long l = 234L;
        BigDecimal bigDecimal = new BigDecimal("3333.33");
        System.out.println(bigDecimal);
        System.out.println(String.format("%04d", l));
        Weekly347 weekly347 = new Weekly347();
        weekly347.differenceOfDistinctValues(new int[][]{{1,2,3},{3,1,5},{3,2,1}});
    }
}
