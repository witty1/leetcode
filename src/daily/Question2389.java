package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/longest-subsequence-with-limited-sum/description/
 * @since 2023/3/17 9:27
 */
public class Question2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        int[] cnt = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            cnt[i + 1] = cnt[i] + nums[i];
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = binarySearch(cnt, queries[i]) - 1;
        }
        return ans;
    }

    private static int binarySearch(int[] nums, int target) {
        int low = 1, high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Question2389().answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})));
//        new Question2389().answerQueries(new int[]{2,3,4,5}, new int[]{1});
    }
}
