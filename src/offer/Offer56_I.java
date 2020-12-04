package offer;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/4
 * @Time: 14:24
 * @Description: No Description
 */
public class Offer56_I {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        int pos = 1;
        while ((res & pos) == 0) {
            pos <<= 1;
        }
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & pos) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Offer56_I o = new Offer56_I();
        Arrays.stream(o.singleNumbers(new int[]{1,2,10,4,1,4,3,3}))
                .forEach(System.out::println);
    }
}
