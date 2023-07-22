package weekly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-336/
 * @since 2023/3/17 14:33
 */
public class Weekly336 {
    public int vowelStrings(String[] words, int left, int right) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int ans = 0;
        while (left <= right) {
            String word = words[left];
            if (set.contains(word.charAt(0)) && set.contains(word.charAt(word.length() - 1))) {
                ans++;
            }
            left++;
        }
        return ans;
    }

    public int maxScore(int[] nums) {
        int ans = 0;
        long sum = 0;
        int i = 0;
        for (int num : nums) {
            if (num > 0){
                sum += num;
                ans++;
            }else {
                nums[i++] = num;
            }
        }
        if (sum <= 0){
            return 0;
        }
        Arrays.sort(nums, 0, i);
        while (--i >= 0){
            sum += nums[i];
            if (sum <= 0){
                break;
            }
            ans++;
        }
        return ans;
    }
}
