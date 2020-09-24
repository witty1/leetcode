package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/23
 * @Time: 11:05
 * @Description: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class Interview34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int n = nums.length;
        int first = search(nums, target, 0, n, true);
        if (first == nums.length || nums[first] != target) {
            return res;
        }
        res[0] = first;
        res[1] = search(nums, target, 0, n, false) - 1;
        return res;
    }

    public int search(int[] nums, int target, int l, int r, boolean left) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target || (left && nums[mid] == target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
