package daily;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/make-sum-divisible-by-p/
 * @since 2023/3/10 20:56
 */
public class Question1590 {
    public int minSubarray(int[] nums, int p) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] cnt = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            cnt[i + 1] = (cnt[i] + nums[i]) % p;
        }
        int n = cnt[nums.length];
        if (n == 0){
            return 0;
        }

        int ans = nums.length;
        for (int i = 0; i < cnt.length; i++) {
            map.put(cnt[i], i);
            int  j = map.getOrDefault((cnt[i] - n + p) % p, -n);
            ans = Math.min(ans, i - j);
        }
        return ans < nums.length ? ans : -1;
    }

    public static void main(String[] args) {
        Question1590 question1590 = new Question1590();
//        System.out.println(question1590.minSubarray(new int[]{3, 1, 4, 2}, 6));
        System.out.println(question1590.minSubarray(new int[]{3, 6, 8, 1}, 8));
    }
}
