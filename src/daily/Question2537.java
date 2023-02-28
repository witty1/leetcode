package daily;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/make-array-zero-by-subtracting-equal-amounts/
 * @since 2023/2/24 16:36
 */
public class Question2537 {

    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0){
                set.add(num);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        Question2537 question2537 = new Question2537();
        System.out.println(question2537.minimumOperations(new int[]{1, 5, 0, 3, 5}));
    }
}
