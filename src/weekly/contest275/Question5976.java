package weekly.contest275;

import java.util.HashSet;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/9 10:36
 * @description: https://leetcode-cn.com/contest/weekly-contest-275/problems/check-if-every-row-and-column-contains-all-numbers/
 */
public class Question5976 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < matrix[i].length; j++) {
                hashSet.add(matrix[i][j]);
            }
            if (hashSet.size() != n){
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                hashSet.add(matrix[j][i]);
            }
            if (hashSet.size() != n){
                return false;
            }
        }
        return true;
    }
}
