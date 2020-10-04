package offer;

import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/4
 * @Time: 14:34
 * @Description: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 */
public class Offer09 {

    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {

            if (stack2.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            if (stack2.isEmpty()){
                return -1;
            }
            return stack2.pop();
        }
    }
}
