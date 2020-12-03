package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/3
 * @Time: 10:02
 * @Description: No Description
 */
public class Offer56_II {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                count[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<=1;
            res |= count[31-i]%3;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer56_II offer56_ii = new Offer56_II();
        System.out.println(offer56_ii.singleNumber(new int[]{3, 4, 3, 3}));
    }
}
