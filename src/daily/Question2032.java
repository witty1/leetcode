package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/two-out-of-three/
 * @since 2022/12/29 10:15
 */
public class Question2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] cnt = new int[101];
        int len = Math.max(Math.max(nums1.length, nums2.length), nums3.length);
        boolean[] s1 = new boolean[101];
        boolean[] s2 = new boolean[101];
        boolean[] s3 = new boolean[101];
        for (int i = 0; i < len; i++) {
            if (i < nums1.length && !s1[nums1[i]]) {
                cnt[nums1[i]]++;
                s1[nums1[i]] = true;

            }
            if (i < nums2.length && !s2[nums2[i]]) {
                cnt[nums2[i]]++;
                s2[nums2[i]] = true;
            }
            if (i < nums3.length && !s3[nums3[i]]) {
                cnt[nums3[i]]++;
                s3[nums3[i]] = true;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] > 1) {
                list.add(i);
            }
        }
        return list;
    }
}
