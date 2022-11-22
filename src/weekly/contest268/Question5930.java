

package weekly.contest268;

/**
 * TODO
 *
 * @author zhengcp25979
 * @version V2.1
 * @description: https://leetcode-cn.com/contest/weekly-contest-268/problems/two-furthest-houses-with-different-colors/
 * @since 2021/11/21 10:36
 */
public class Question5930 {

    public int maxDistance(int[] colors) {
        if (colors.length <= 2) {
            return 1;
        }
        int maxLength = 0, j = colors.length - 1;
        boolean find = false;
        int modCount = 0;
        for (int i = 0; i <= j && modCount < 2; ) {
            if (colors[i] != colors[j]) {
                maxLength = Math.max(j - i, maxLength);
                modCount++;
                find = true;
                j = colors.length - 1;
                i = 0;
            }
            if (find) {
                i++;
            } else {
                j--;
            }

        }
        return maxLength;
    }

}
