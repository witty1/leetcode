package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/13
 * @Time: 16:39
 * @Description: No Description
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        int row = grid.length, line = grid[0].length;
        int[][] count = new int[row+1][line+1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= line; j++) {
                count[i][j] = Math.max(count[i-1][j],count[i][j-1])+grid[i-1][j-1];
            }
        }
        return count[row][line];
    }

    public static void main(String[] args) {
        int[][] gift = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        Offer47 offer47 = new Offer47();
        System.out.println(offer47.maxValue(gift));
    }
}
