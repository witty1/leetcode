package topInterview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/spiral-matrix/?favorite=2ckc81c
 * @since 2022/9/14 20:08
 */
public class Interview54 {
    public List<Integer> spiralOrder1(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> ans = new LinkedList<>();
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            if (left < right && top < bottom){
                for (int i = right - 1; i > left; i--) {
                    ans.add(matrix[bottom][i]);
                }

                for (int i = bottom; i > top; i--) {
                    ans.add(matrix[i][left]);
                }

            }
            top++;
            right--;
            bottom--;
            left++;
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0;
        List<Integer> ans = new LinkedList<>();
        int maxI = matrix.length - 1;
        int minI = 0;
        int maxJ = matrix[0].length - 1;
        int minJ = 0;
        //
        char point = 'r';
        while (true) {
            ans.add(matrix[i][j]);

            if (judge(point, i, j, maxI, maxJ, minI, minJ)) {
                switch (point) {
                    case 'l':
                        i--;
                        point = 'u';
                        maxI--;
                        break;
                    case 'r':
                        i++;
                        point = 'd';
                        minI++;
                        break;
                    case 'u':
                        j++;
                        point = 'r';
                        minJ++;
                        break;
                    case 'd':
                        j--;
                        point = 'l';
                        maxJ--;
                        break;
                }
                if (i < minI || j < minJ || i > maxI || j > maxJ) {
                    break;
                }
            } else {
                switch (point) {
                    case 'l':
                        j--;
                        break;
                    case 'r':
                        j++;
                        break;
                    case 'u':
                        i--;
                        break;
                    case 'd':
                        i++;
                        break;
                }
            }

        }
        return ans;
    }

    private boolean judge(char point, int i, int j, int maxI, int maxJ, int minI, int minJ) {
        switch (point) {
            case 'l':
                return j - 1 < minJ;
            case 'r':
                return j + 1 > maxJ;
            case 'u':
                return i - 1 < minI;
            case 'd':
                return i + 1 > maxI;
        }
        return false;
    }

    public static void main(String[] args) {
        Interview54 interview54 = new Interview54();
//        interview54.spiralOrder1(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        interview54.spiralOrder1(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}});
//        interview54.spiralOrder1(new int[][]{{1, 2, 3, 4}});
//        interview54.spiralOrder1(new int[][]{{1}, {2}, {3}});
    }
}
