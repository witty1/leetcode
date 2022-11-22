package design;

import java.util.Deque;
import java.util.LinkedList;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @since 2021/12/14 15:03
 */
public class Leetcode225 {
    class MyStack {
        Deque<Integer> deque;
        int top;

        public MyStack() {
            deque = new LinkedList<>();
        }

        public void push(int x) {
            deque.addLast(x);
            top = x;
        }

        public int pop() {
            int size = deque.size();
            if (size == 1) {
                return deque.removeFirst();
            }
            do {
                Integer first = deque.removeFirst();
                //记录一下top
                if (size == 2) {
                    top = first;
                }
                deque.addLast(first);
            } while (--size > 1);
            return deque.removeFirst();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
