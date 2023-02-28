package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2023/1/7 20:16
 */
public class Question1658 {


    public int minOperations(int[] nums, int x) {
        int ans = Integer.MAX_VALUE;
        int lsum = 0;
        int r = 0;
        int rSum = 0;
        for (int num : nums) {
            rSum += num;
        }
        if (rSum < x){
            return -1;
        }
        for (int l = -1; l < nums.length; l++){
            if (l != -1){
                lsum += nums[l];
            }
            while (r < nums.length && lsum + rSum > x){
                rSum -= nums[r];
                r++;
            }
            if (lsum + rSum == x){
                ans = Math.min(ans, nums.length - r + l + 1);
            }
        }

        return ans > nums.length ? -1 : ans;
    }

    public static void main(String[] args) {
        Question1658 question1658 = new Question1658();
        System.out.println(question1658.minOperations(new int[]{5, 6, 7, 8, 9}, 4));
//        System.out.println(question1658.minOperations(new int[]{6016, 5483, 541, 4325, 8149, 3515, 7865, 2209, 9623, 9763, 4052, 6540, 2123, 2074, 765, 7520, 4941, 5290, 5868, 6150, 6006, 6077, 2856, 7826, 9119}, 31841));
    }
}
