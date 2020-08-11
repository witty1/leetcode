package interview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/11
 * @Time: 11:04
 * @Description: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindNumberIn2DArray {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            int index = 0;
            if (target >= matrix[index][i]) {
                while (index < matrix.length) {
                    if (target == matrix[index][i]) {
                        return true;
                    }
                    ++index;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findNumberIn2DArray(new int[][]{new int[]{-1, 3}}, -1));
    }
}
