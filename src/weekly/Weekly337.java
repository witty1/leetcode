package weekly;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-337/
 * @since 2023/3/24 11:01
 */
public class Weekly337 {
    public int[] evenOddBit(int n) {
        int i = 0;
        int even = 0, odd = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if ((i & 1) == 1) {
                    odd++;
                } else {
                    even++;
                }
            }
            n >>= 1;
            i++;
        }
        return new int[]{even, odd};
    }


    public boolean checkValidGrid(int[][] grid) {
        int max = grid.length * grid[0].length;
        int[][] cnt = new int[max][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                cnt[grid[i][j]] = new int[]{i, j};
            }
        }
        if (cnt[0].length == 0 || cnt[0][0] != 0 || cnt[0][1] != 0) {
            return false;
        }
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i].length == 0) {
                return false;
            }
            int difX = Math.abs(cnt[i][0] - cnt[i - 1][0]);
            int difY = Math.abs(cnt[i][1] - cnt[i - 1][1]);
            if (difX == 1 && difY == 2) {
                continue;
            }
            if (difX == 2 && difY == 1) {
                continue;
            }
            return false;
        }
        return true;
    }




    public static void main(String[] args) {
        Weekly337 weekly337 = new Weekly337();
        boolean b = weekly337.checkValidGrid(new int[][]{{0, 11, 16, 5, 20}, {17, 4, 19, 10, 15}, {12, 1, 8, 21, 6}, {3, 18, 23, 14, 9}, {24, 13, 2, 7, 22}});
    }
}
