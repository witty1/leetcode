package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/5
 * @Time: 14:55
 * @Description: No Description
 */
public class Offer10_II {
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int f1 = 0, f2 = 1, res = 0;
        for (int i = 0; i < n; i++) {
            res = (f1 + f2) % 1000000007;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
