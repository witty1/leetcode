package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/7
 * @Time: 8:32
 * @Description: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class Offer53_I {


    public int search(int[] nums, int target) {
        int count = 0, l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                count++;
                int t = mid;
                while (--t >= 0 && nums[t] == target) {
                    count++;
                }
                while (++mid < nums.length && nums[mid] == target) {
                    count++;
                }
                return count;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        return count;
    }

    public int search1(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }

    int helper(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Offer53_I o = new Offer53_I();
        System.out.println(o.search1(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }


}
