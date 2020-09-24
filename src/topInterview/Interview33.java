package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/22
 * @Time: 11:15
 * @Description: https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class Interview33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0]<=target &&  target<nums[mid]) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }else {
                if (nums[mid]<target && target<=nums[n-1]){
                    l = mid +1;
                }else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


}
