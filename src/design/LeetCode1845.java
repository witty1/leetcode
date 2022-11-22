package design;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/seat-reservation-manager/
 * @since 2022/9/8 14:16
 */
public class LeetCode1845 {
    class SeatManager {
        PriorityQueue<Integer> queue;
        int pos = 1;

        public SeatManager(int n) {
            queue = new PriorityQueue<>(n);
        }

        public int reserve() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
            return pos++;
        }


        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }
}
