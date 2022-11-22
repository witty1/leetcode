package weekly.contest310;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-310/
 * @since 2022/9/12 19:45
 */
public class Question310 {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100001];
        int min = -1, total = 0;
        for (int num : nums) {
            if ((num & 1) == 0) {
                count[num]++;
                if (count[num] > total) {
                    min = num;
                    total = count[num];
                } else if (count[num] == total) {
                    min = Math.min(num, min);
                }
            }
        }
        return min;
    }

    public int partitionString(String s) {
        int res = 1;
        int sum = 0;
        for (char c : s.toCharArray()) {
            int move = c - 'a';
            if ((sum >>> move & 1) != 0) {
                sum = 0;
                res++;
            }
            sum |= 1 << (move & 31);
        }
        return res;
    }

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }
            return x[0] - y[0];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (queue.isEmpty()) {
                queue.add(interval[1]);
                continue;
            }
            if (interval[0] > queue.peek()) {
                queue.poll();
            }
            queue.add(interval[1]);

        }
        return queue.size();
    }

    public static void main(String[] args) {
        Question310 question310 = new Question310();
        question310.minGroups(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}});
    }
}
