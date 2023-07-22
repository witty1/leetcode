package weekly;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-348
 * @since 2023/6/4 10:28
 */
public class Weekly348 {

    public int minimizedStringLength(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        return set.size();
    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                a = i;
            } else if (nums[i] == n) {
                b = i;
            }
        }
        if (b < a) {
            return a + n - b - 2;
        } else {
            return a + n - b - 1;
        }
    }


    public long matrixSumQueries(int n, int[][] queries) {
        int[] row = new int[n + 1];
        int cntR = 0;
        int[] col = new int[n + 1];
        long ans = 0;
        int cntC = 0;
        int num = 0;
        int max = n * n;
        for (int i = queries.length - 1; i >= 0 && num != max; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];
            if (type == 0 && row[index] == 0) {
                row[index] = n - col[index];
                if (row[index] == 0) {
                    continue;
                }
                ans += (long) val * row[index];
                num += row[index];
            } else if (type == 1 && col[index] == 0) {
                col[index] = n - row[index];
                if (col[index] == 0) {
                    continue;
                }
                ans += (long) val * col[index];
                num += col[index];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String str = "00|成功[0000000]|252203291638400338998|033899|0329163840|0329|033929000000001|20220329150443|156|2000|01|6216261000000000018|全渠道|000501|01|341126197709218366|13552535506|04|880006501";
        String[] split1 = str.split("\n");
        String[] split = str.split("\\|");
        System.out.println(Arrays.toString(split));
        Date date = new Date();
        Date date1 = new Date();
        System.out.println(date.compareTo(date1));
        String s = "expireOverdueDays";
        System.out.println(s.replaceAll("([a-z])([A-Z])", "$1_$2").toUpperCase(Locale.ROOT));

        Weekly348 weekly348 = new Weekly348();
        System.out.println("1".equals(null));

        System.out.println(weekly348.matrixSumQueries(3, new int[][]{{0, 0, 1}, {1, 2, 3}, {0, 2, 3}, {1, 0, 4}}));
    }
}
