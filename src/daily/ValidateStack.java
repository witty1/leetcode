package daily;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/14
 * @Time: 19:37
 * @Description: https://leetcode-cn.com/problems/validate-stack-sequences/
 */
@SuppressWarnings("all")
public class ValidateStack {
    public static boolean validateStackSequences1(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        int i = 0, j = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (i < pushed.length && j < popped.length) {
            deque.addLast(pushed[i]);
            while (!deque.isEmpty() && deque.peekLast() == popped[j]) {
                deque.removeLast();
                j++;
            }
            i++;
        }
        return i == j;
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        int i = 0, j = 0;
        Deque<Integer> deque = new LinkedList<>();
        while (i < pushed.length && j < popped.length) {
            if (pushed[i] == popped[j]) {
                i++;
                j++;
                while (j < popped.length && deque.peek() != null && popped[j] == deque.peekLast()) {
                    deque.removeLast();
                    j++;
                }
                continue;
            }
            deque.addLast(pushed[i]);
            i++;
        }
        return i == j;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(push, pop));
    }
}
