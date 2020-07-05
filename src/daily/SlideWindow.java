package daily;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/3
 * @Time: 9:49
 * @Description: https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlideWindow {
    //暴力法
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int count = nums.length - k + 1;
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int count = 0;
        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                res[count++] = nums[queue.peek()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = maxSlidingWindow1(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
