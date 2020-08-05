package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/2
 * @Time: 10:06
 * @Description: No Description
 */
public class Combinations {
    int a, b;

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        construct(1, new ArrayList<>(), n ,k,res);
        return res;
    }

    public static void construct(int first, List<Integer> list, int n, int k,List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(list);
            list = new ArrayList<>();
        }
        for (int i = first; i <= n; i++) {
            list.add(i);
            construct(i+1,list, n ,k,res);
        }
    }

    public static void main(String[] args) {
        combine(4,2);
    }
}
