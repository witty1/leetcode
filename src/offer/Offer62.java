package offer;

import java.util.PriorityQueue;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/18
 * @Time: 15:28
 * @Description: No Description
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
