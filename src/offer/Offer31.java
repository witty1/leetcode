package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/11
 * @Time: 9:03
 * @Description: No Description
 */
public class Offer31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length==0){
            return true;
        }
        Deque<Integer> push = new LinkedList<>();
        int i = 0;
        for (int i1 : pushed) {
            push.add(i1);
            while (push.size() > 0 && push.peekLast() == popped[i]) {
                push.removeLast();
                i++;
            }
        }
        return push.size() == 0;
    }

    public static void main(String[] args) {
        Offer31 offer31 = new Offer31();
        System.out.println(offer31.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
    }
}
