package weekly.contest309;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-309/
 * @since 2022/9/22 14:38
 */
public class Question309 {
    public boolean checkDistances(String s, int[] distance) {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int idx = array[i] - 'a';
            if (count[idx] == -1) {
                count[idx] = i;
            } else {
                count[idx] = i - count[idx] - 1;
                if (count[idx] != distance[idx]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 1  5  10
    // 1-2-3-4-5-6-
//    public int numberOfWays(int startPos, int endPos, int k) {
//        if (endPos - startPos > k){
//            return 0;
//        }
//    }

    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(3 & 8);
    }
}
