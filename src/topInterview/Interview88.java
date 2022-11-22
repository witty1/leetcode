

package topInterview;

import java.util.Arrays;

/**
 * TODO
 *
 * @author wit
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/merge-sorted-array/
 * @since 2021/9/5 21:46
 */
public class Interview88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0, count = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (count == m) {
                nums1[i] = nums2[index++];
                continue;
            }
            if (index < n && nums1[i] > nums2[index]) {
                if (i + 1 < nums1.length) {
                    System.arraycopy(nums1, i, nums1, i + 1, nums1.length - i - 1);
                }
                nums1[i] = nums2[index++];
            } else {
                count++;
            }
        }
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = nums1.length - 1; i >= m; i--) {
            nums1[i] = nums2[--n];
        }
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int x = 0, y = 0;
        int[] res = new int[m + n];
        for (int i = 0; i < res.length; i++) {
            if (x == m) {
                res[i] = nums2[y++];
            } else if (y == n) {
                res[i] = nums1[x++];
            } else if (nums1[x] <= nums2[y]) {
                res[i] = nums1[x++];
            } else if (nums1[x] > nums2[y]) {
                res[i] = nums2[y++];
            }
        }
        System.arraycopy(res, 0, nums1, 0, nums1.length);
    }

    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        for (int i = nums1.length - 1; i >= 0 && n >= 0; i--) {
            if (m < 0) {
                nums1[i] = nums2[n--];
            } else if (nums1[m] >= nums2[n]) {
                nums1[i] = nums1[m--];
            } else if (nums1[m] < nums2[n]) {
                nums1[i] = nums2[n--];
            }
        }
    }

    public static void main(String[] args) {
        final int[] nums1 = {4, 5, 6, 0, 0, 0};
        new Interview88().merge3(nums1, 3, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
