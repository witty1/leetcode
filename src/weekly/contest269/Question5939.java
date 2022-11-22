package weekly.contest269;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/11/28 11:14
 */
public class Question5939 {
    public int[] getAverages(int[] nums, int k) {
        int[] res = new int[nums.length];
        int count = 2*k+1;
        long sum = 0;
        for (int i = 0; i < count && i<nums.length; i++) {
            sum+= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i - k < 0 || i + k >= nums.length){
                res[i] = -1;
                continue;
            }
            res[i] = (int) (sum / count);
            sum -= nums[i - k];
            if ((i + k + 1) < nums.length){
                sum += nums[i + k + 1];
            }


        }
        return res;
    }


    public int[] getAverages1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = nums[i - 1] + sum[i - 1];
        }
        Arrays.fill(res, -1);
        for (int i = k; i < n - k; i++) {
            res[i] = (int) ((sum[i + k + 1] - sum[i - k]) /(2* k + 1));
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println(String.valueOf(1234).toCharArray());
    }

}
