package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/15
 * @Time: 16:36
 * @Description: No Description
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int line : row) {
                if (target == line) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = matrix.length - 1,line = 0;
        while (row >= 0 && line >=0){
            if (target < matrix[row][line]){
                row --;
            }else if (target > matrix[row][line]){
                line ++ ;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}
//        {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}
        Offer04 offer04 = new Offer04();
        System.out.println(offer04.findNumberIn2DArray2(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
    }
}
