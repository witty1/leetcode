package daily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/11
 * @Time: 19:02
 * @Description: No Description
 */
public class CombinationSum3 {
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        recursion(1, k, n, new ArrayDeque<>());
        return res;
    }

    public static void recursion(int i, int k, int n, Deque<Integer> deque) {
        if (k <= 0 || i > n) {
            if (n == 0 && k == 0) {
                res.add(new ArrayList<>(deque));
            }
            return;
        }
        for (; i <= 9; i++) {
            deque.addLast(i);
            recursion(i + 1, k - 1, n - i, deque);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        combinationSum3(1, 1);
    }
}
