package sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/13 15:01
 */
public class MergeSort {
    public static int[] mergeSort(int[] nums) {
        divide(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    public static void divide(int[] nums, int left, int right, int[] temp) {
        if (right > left) {
            int mid = (left + right) >> 1;
            divide(nums, left, mid, temp);
            divide(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }

    }

    public static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, t=0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]){
                temp[t++] = nums[i++];
            }else {
                temp[t++] = nums[j++];
            }
        }
        while (i <= mid){
            temp[t++] = nums[i++];
        }
        while (j<=right){
            temp[t++] = nums[j++];
        }
        t = 0;
        while (left<=right){
            nums[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,6,3,2,6,7,0};
        int[] sort = mergeSort(nums);
        System.out.println(Arrays.toString(sort));
    }


}
