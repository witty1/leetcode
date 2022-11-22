package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/21
 * @Time: 14:09
 * @Description: https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 */
public class Offer59_II {
    static class MaxQueue {
        private LinkedList<Integer> queue;
        private LinkedList<Integer> deque;

        public MaxQueue() {
            deque = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.getFirst();
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
            queue.add(value);

        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer num = queue.remove();
            if (num.equals(deque.getFirst())) {
                deque.removeFirst();
            }
            return num;
        }
    }

}
