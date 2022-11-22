package weekly.contest289;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode-cn.com/contest/weekly-contest-289
 * @since 2022/4/17 10:25
 */
public class Question289 {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > k) {
            for (int i = 0; i < s.length(); i += k) {
                String temp = s.substring(i, Math.min((i + k), s.length()));
                int res = 0;
                for (int j = 0; j < temp.length(); j++) {
                    res += Integer.parseInt(String.valueOf(temp.charAt(j)));
                }
                sb.append(res);
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s;
    }


    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value < 2) {
                return -1;
            }
            if (value > 3) {
                res += value / 3;
                if (value % 3 != 0) {
                    res++;
                }
            } else {
                res++;
            }

        }
        return res;
    }

    public int maxTrailingZeros(int[][] grid) {
        HashMap<Integer, TreeSet<Integer>> row = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> line = new HashMap<>();
        int length = grid.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int unit = grid[i][j] % 10;
                if (unit == 5 || unit == 0) {
                    TreeSet<Integer> set = line.getOrDefault(i, new TreeSet<>());
                    set.add(j);
                    line.put(i, set);
                }
            }
        }
        //扫描列
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < length; j++) {
                int unit = grid[j][i] % 10;
                if (unit == 5 || unit == 0) {
                    TreeSet<Integer> set = row.getOrDefault(i, new TreeSet<>());
                    set.add(j);
                    row.put(i, set);
                }
            }
        }
        int count = 0;
        if ((row.size() == 0 && line.size() == 0)) {
            return count;
        }
        for (Map.Entry<Integer, TreeSet<Integer>> lineEntry : line.entrySet()) {
            TreeSet<Integer> lineSet = lineEntry.getValue();
            for (Map.Entry<Integer, TreeSet<Integer>> rowEntry : row.entrySet()) {
                int size = lineSet.tailSet(rowEntry.getKey()).size();
                long res = 1;
                //左边比右边多
                int lineIdx = lineEntry.getKey();
                if (lineSet.size() - size > size) {

                    int rowIdx = -1;

                    while (true) {
                        if (rowIdx == rowEntry.getKey()) {
                            lineIdx++;
                        }else {
                            rowIdx++;
                        }
                        if (lineIdx >= length) {
                            break;
                        }
                        res *= grid[lineIdx][rowIdx];
                    }
                    count = getZeroCount(res, count);
                }else {
                    int rowIdx = grid[lineIdx].length;

                    while (true) {
                        if (rowIdx == rowEntry.getKey()) {
                            lineIdx++;
                        }else {
                            rowIdx--;
                        }
                        if (lineIdx >= length) {
                            break;
                        }
                        res *= grid[lineIdx][rowIdx];
                    }
                    count = getZeroCount(res, count);
                }
            }
        }

        return count;
    }

    private int getZeroCount(long num, int count) {
        int temp = 0;
        while (num % 10== 0) {
            temp++;
            num = num / 10;
        }
        return Math.max(temp, count);
    }


    public static void main(String[] args) {
//        new Question289().maxTrailingZeros(new int[][]{{10}, {6}, {15}});
        new Question289().maxTrailingZeros(new int[][]{{10, 5, 15}});
    }

}
