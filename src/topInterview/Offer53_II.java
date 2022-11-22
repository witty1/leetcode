package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/8
 * @Time: 15:53
 * @Description: No Description
 */
public class Offer53_II {
    public int missingNumber(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == mid) {
                l = mid + 1;
            } else  {
                r = mid - 1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        Offer53_II o = new Offer53_II();
        System.out.println(o.missingNumber(new int[]{0}));
    }
}
