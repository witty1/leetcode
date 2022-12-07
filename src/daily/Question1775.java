package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/equal-sum-arrays-with-minimum-number-of-operations/
 * @since 2022/12/7 9:20
 */
public class Question1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int operate = 0;
        int sum1 = 0, sum2 = 0;
        for (int j : nums1) {
            sum1 += j;
        }
        for (int j : nums2) {
            sum2 += j;
        }
        if (sum1 == sum2) {
            return 0;
        }
        if (sum1 > sum2) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tempSum = sum1;
            sum1 = sum2;
            sum2 = tempSum;
        }
        int dif = sum2 - sum1;
        for (int i = 0, j = nums2.length - 1; i < nums1.length || j >= 0; ) {
            int sub1 = 0, sub2 = 0;
            if (i < nums1.length) {
                sub1 = 6 - nums1[i];
            }
            if (j >= 0) {
                sub2 = nums2[j] - 1;
            }
            if (sub1 <= sub2) {
                if (dif > sub2) {
                    dif -= sub2;
                    operate++;
                } else {
                    return ++operate;
                }
                j--;
            }
            if (sub1 >= sub2) {
                if (dif > sub1) {
                    dif -= sub1;
                    operate++;
                } else {
                    return ++operate;
                }
                i++;
            }

        }
        return -1;
    }


    public int minOperations1(int[] nums1, int[] nums2){
        if (nums1.length * 6 < nums2.length || nums2.length * 6 < nums1.length){
            return -1;
        }
        int d = 0;
        int[] cnt = new int[6];
        for (int i : nums1) {
            d -= i;
        }
        for (int i : nums2) {
            d += i;
        }
        if (d < 0){
            d = -d;
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i : nums1) {
            cnt[6 - i]++;
        }
        for (int i : nums2) {
            cnt[i - 1]++;
        }
        for (int i = 5,ans = 0; ; i--) {
            int sum = i * cnt[i];
            if (d <= sum){
                return ans + (d + i - 1) / i;
            }
            d -= sum;
            ans += cnt[i];
        }

    }


    public static void main(String[] args) {
        Question1775 question1775 = new Question1775();
        System.out.println(question1775.minOperations(new int[]{1, 5, 5, 2, 1, 1, 1, 1, 4, 4, 4, 1, 5, 2, 2, 4, 6, 5, 1, 5, 3, 5, 6, 2, 3, 1, 5, 4, 4, 1, 2, 4, 1, 1, 6, 3, 6, 4, 4, 4, 3, 5, 5, 5, 2, 6, 4, 2, 5, 4, 2, 6, 3, 4, 6, 1, 5, 3, 2, 3, 5, 2, 1, 3, 2, 4, 4, 4, 5, 3, 5, 5, 4, 1, 1, 6, 5, 6, 3, 5, 3, 6, 5, 6, 5, 4, 4, 4, 5, 6, 6, 6, 4, 2, 4, 6, 1, 2, 1, 5, 3, 4, 5, 5, 6, 6, 1, 4, 3, 1, 5, 3, 4, 1, 2, 1, 4, 4, 5, 6, 5, 3, 1, 5, 1, 3, 3, 6, 5, 3, 5, 6, 2, 6, 3, 1, 2, 3, 3, 1, 1, 4, 3, 2, 6, 6, 2, 1, 2, 4, 3, 5, 5, 4, 3, 1, 1, 5, 2, 5, 1, 4, 5, 6, 4, 5, 2, 1, 2, 5, 3, 2, 6, 3, 4, 3, 4, 5, 4, 6, 3, 4, 4, 3, 3, 4, 2, 2, 6, 2, 6, 3, 1, 1, 5, 3, 1, 1, 4, 2, 5, 5, 5, 4, 3, 6, 5, 5, 5, 1, 1, 3, 6, 2, 3, 6, 3, 4, 2, 5, 4, 4, 3, 5, 6, 4, 3, 5, 1, 1, 3, 3, 1, 1, 6, 4, 6, 2, 1, 4, 3, 5, 5}, new int[]{1, 2, 5, 4, 3, 3, 5, 1, 1, 6, 2, 5, 4, 4, 5, 6, 6, 4, 2, 5, 6, 2, 3, 4, 5, 2, 4, 4, 3, 6, 6, 5, 4, 1, 2, 1, 2, 3, 3, 2, 6, 1, 1, 1, 1, 3, 5, 6, 2, 1, 1, 1, 4, 6, 5}));
    }
}
