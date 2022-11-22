package weekly.contest286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/3/28 20:16
 */
public class Question286 {

    /**
     * https://leetcode-cn.com/problems/find-the-difference-of-two-arrays/
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        int[] count1 = new int[20001];
        int[] count2 = new int[20001];
        for (int i : nums1) {
            count1[i + 1000]++;
        }
        for (int i : nums2) {
            count2[i + 1000]++;
        }
        for (int i = 0; i < count1.length; i++) {
            if (count1[i] == 0) {
                if (count2[i] != 0) {
                    list2.add(i - 1000);
                }
            } else if (count2[i] == 0) {
                if (count1[i] != 0) {
                    list1.add(i - 1000);
                }
            }
        }
        return res;
    }

    /**
     * https://leetcode-cn.com/problems/minimum-deletions-to-make-array-beautiful/
     *
     * @param nums
     * @return
     */
    public int minDeletion(int[] nums) {
        // 2 2 2
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int num : nums) {
            if ((deque.size() & 1) == 0) {
                deque.addFirst(num);
            } else {
                if (deque.getFirst() == num) {
                    res++;
                } else {
                    deque.addFirst(num);
                }
            }
        }
        return (deque.size() & 1) == 0 ? res : ++res;
    }

    public int minDeletion1(int[] nums) {
        // 2 2 2
        int res = 0;
        int left = 0, right = 1;
        while (right < nums.length) {
            if ((left & 1) != 0) {
                left++;
                nums[left] = nums[right];
            } else {
                if (nums[left] == nums[right]) {
                    res++;
                } else {
                    left++;
                    nums[left] = nums[right];
                }
            }
            right++;
        }
        return (left & 1) == 0 ? ++res : res;
    }

    public static void main(String[] args) {
        new Question286().minDeletion1(new int[]{1, 1, 2, 2, 3, 3});
    }
}
