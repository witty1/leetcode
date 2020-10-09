package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/9
 * @Time: 14:57
 * @Description: No Description
 */
public class Offer13 {
    int res = 0;
    int[][] square;
    public int movingCount(int m, int n, int k) {
        square = new int[m][n];
        query(0, 0, k);
        return res;
    }

    public void query(int i, int j, int k) {
        if (i < 0 || j < 0 || i >= square.length || j >= square[0].length || square[i][j] != 0) {
            return;
        }
        if (square[i][j] == 0) {
            int t = get(i) + get(j);
            if (t <= k) {
                square[i][j] = 1;
                query(i + 1, j, k);
                query(i, j + 1, k);
                res++;
            }
        }

    }

    public int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
