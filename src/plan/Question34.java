package plan;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @since 2022/1/29 19:51
 */
public class Question34 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0, right = nums.length - 1, mid = 0;
        while (true) {
            if (left > right) {
                left = -1;
                right = -1;
                break;
            }
            mid = (left + right) >> 1;
            if (nums[mid] == target) {
                left = mid;
                right = mid;
                while (--left >= 0 && nums[left] == target) {
                }
                while (++right < nums.length && nums[right] == target) {
                }
                ++left;
                --right;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[]{left, right};
    }

    public int[] searchRange1(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int len = nums.length - 1;
        int first = search(0, len, nums, target, (byte) 1);
        if (first == nums.length || nums[first] != target) {
            return res;
        }
        res[0] = first;
        res[1] = search(0, len, nums, target, (byte) 0);
        return res;
    }

    public int search(int l, int r, int[] nums, int target, byte flag) {
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target || (flag == 1 && nums[mid] == target)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
