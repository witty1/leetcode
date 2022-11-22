package codeTop;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/4/26
 * @Time: 8:31
 * @Description: 数组中的第K个最大元素
 */
public class Question215 {

    //冒泡排序
    public int findKthLargest(int[] nums, int k) {
        int a = k;
        for (int i = 0; i < nums.length - 1; i++) {
            k--;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (k <= 0) {
                return nums[nums.length - a];
            }
        }
        return nums[0];
    }

    public int findKthLargest1(int[] nums, int k) {
        return 0;
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int left = l;
            int right = r;
            int pivot = nums[l];
            while (left < right) {
                while (left < right && nums[right] > pivot) {
                    right--;
                }
                if (left < right){
                    nums[left++] = nums[right];
                }
                while (left < right && nums[left] < pivot) {
                    left++;
                }


                if (left < right) {
                   nums[right--] = nums[left];
                }
            }
            nums[left] = pivot;
            System.out.println(Arrays.toString(nums));

            quickSort(nums, l, left -1);
            quickSort(nums, left + 1, nums.length-1);
        }
    }


    public static void main(String[] args) {
        Question215 question215 = new Question215();
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
//        System.out.println(question215.findKthLargest(nums, 2));
        question215.quickSort(nums,0,nums.length-1);
    }
}
