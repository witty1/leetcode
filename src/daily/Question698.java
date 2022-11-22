package daily;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/9/20 9:13
 */
public class Question698 {

    static boolean used[];

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;

        Arrays.sort(nums);
        int max = nums.length - 1;
        if (nums[max] > target) {
            return false;
        }
        used = new boolean[nums.length];
        return recur(max, target, 0, k, nums);
    }


    private static boolean recur(int start, int target, int now, int k, int[] nums) {
        if (k == 0) {
            return true;
        }
        if (target == now) {
            return recur(nums.length - 1, target, 0, k - 1, nums);
        }
        for (int i = start; i >= 0; i--) {
            if (used[i] || now + nums[i] > target) {
                continue;
            }
            used[i] = true;
            if (recur(i, target, now + nums[i], k, nums)) {
                return true;
            }
            used[i] = false;
            while (i > 0 && nums[i] == nums[i - 1]) {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "asset、platform-common、user、market、guard、business-center、busines-batch-job、project-batch-job、mdata、admin、admin-query、acctcenter、acctdayend、convert";
        StringTokenizer tokenizer = new StringTokenizer(str, "、");
        while (tokenizer.hasMoreTokens()){
            String s = tokenizer.nextToken();
            char[] array = s.toCharArray();
            System.out.print(s + ":\n");
            for (char c : array) {
                System.out.print((c - 'a') + "\t");
            }
            System.out.println();
        }
        System.out.println(Integer.MAX_VALUE);

        char a = 'a';
        char c = 'c';
        char p = 'p';
        char u = 'u';
        char m = 'm';
        char g = 'g';

        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
    }
}
