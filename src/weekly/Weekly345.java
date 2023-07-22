package weekly;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-345
 * @since 2023/5/14 10:25
 */
public class Weekly345 {

    public int[] circularGameLosers(int n, int k) {
        int len = n;
        int[] cnt = new int[len];
        int i = 0;
        int num = 0;
        while (cnt[i] != 1) {
            cnt[i] = 1;
            num++;
            i = (i + num * k) % len;
        }
        ArrayList<Integer> temp = new ArrayList<>();
        for (int j = 0; j < cnt.length; j++) {
            if (cnt[j] == 0) {
                temp.add(j);
            }
        }
        int[] res = new int[temp.size()];
        for (int i1 = 0; i1 < temp.size(); i1++) {
            res[i1] = temp.get(i1) + 1;
        }
        return res;
    }

    public boolean doesValidArrayExist1(int[] derived) {
        int n = 0;
        for (int i : derived) {
            n ^= i;
        }
        return n == 0;
    }

    public boolean doesValidArrayExist(int[] derived) {
        if (derived.length == 1) {
            return derived[0] == 0;
        }
        int[] possible = new int[derived.length];
        int i = 0;
        if (derived[i] == 1) {
            possible[i] = 1;
            possible[i + 1] = 0;
            if (recur(derived, i + 1, possible)) {
                return true;
            }
            possible[i] = 0;
            possible[i + 1] = 1;
            return recur(derived, i + 1, possible);
        } else {
            possible[i] = 1;
            possible[i + 1] = 1;
            if (recur(derived, i + 1, possible)) {
                return true;
            }
            possible[i] = 0;
            possible[i + 1] = 0;
            return recur(derived, i + 1, possible);
        }
    }

    private boolean recur(int[] derived, int index, int[] possible) {
        if (index >= derived.length - 1) {
            return (possible[derived.length - 1] ^ possible[0]) == derived[derived.length - 1];
        }
        for (int i = index; i < derived.length; i++) {
            if (derived[i] == 0) {
                if (possible[i] == 1) {
                    possible[i + 1] = 1;
                } else if (possible[i] == 0) {
                    possible[i + 1] = 0;
                }
                return recur(derived, i + 1, possible);
            } else if (derived[i] == 1) {
                if (possible[i] == 1) {
                    possible[i + 1] = 0;
                } else if (possible[i] == 0) {
                    possible[i + 1] = 1;
                }
                return recur(derived, i + 1, possible);

            }
        }
        return false;
    }


    int[][] direction = new int[][]{{-1, 1}, {0, 1}, {1, 1}};

    public int maxMoves(int[][] grid) {
        int row = 0;
        int max = 0;
        while (row < grid.length) {
            max = Math.max(dfs(grid, row, 0, 0), max);
            if (max == grid[0].length - 1) {
                break;
            }
            row++;
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int move) {
        int max = move;
        for (int[] ints : direction) {
            int x = ints[0] + row;
            int y = ints[1] + col;
            if (x < 0 || x >= grid.length || y >= grid[0].length || grid[row][col] >= grid[x][y]) {
                continue;
            }
            max = Math.max(dfs(grid, x, y, move + 1), max);
            if (max == grid[0].length - 1) {
                return max;
            }
        }
        return max;
    }


    public static void main(String[] args) {

        BigDecimal s = new BigDecimal(2423.3242);
        System.out.println(s);
        Weekly345 weekly345 = new Weekly345();
//        System.out.println(weekly345.maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
        System.out.println(weekly345.maxMoves(new int[][]{{187, 167, 209, 251, 152, 236, 263, 128, 135}, {267, 249, 251, 285, 73, 204, 70, 207, 74}, {189, 159, 235, 66, 84, 89, 153, 111, 189}, {120, 81, 210, 7, 2, 231, 92, 128, 218}, {193, 131, 244, 293, 284, 175, 226, 205, 245}}));
    }
}
