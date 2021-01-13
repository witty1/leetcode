package offer;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/30
 * @Time: 14:09
 * @Description: No Description
 */
public class Offer30 {
    class MinStack {
        private LinkedList<Integer> a, b;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            a = new LinkedList<>();
            b = new LinkedList<>();
        }

        public void push(int x) {
            a.addLast(x);
            if (b.isEmpty() || b.peekLast() >= x){
                b.addLast(x);
            }

        }

        public void pop() {
            if (a.pollLast().equals(b.peekLast())) {
                b.pollLast();
            }
        }

        public int top() {
            return a.peekLast();
        }

        public int min() {
            return b.peekLast();
        }
    }
}
