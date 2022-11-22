package daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/14
 * @Time: 15:58
 * @Description: https://leetcode-cn.com/problems/binary-prefix-divisible-by-5/
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * 示例 1：
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * <p>
 * 示例 2：
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * <p>
 * 示例 3：
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 */
public class Question1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        Boolean[] res = new Boolean[A.length];

        int prefix = 0;
        for (int i = 0; i < A.length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            res[i] = prefix == 0;
        }
        return Arrays.asList(res);
    }

    public static void main(String[] args) {
        Question1018 q = new Question1018();
        System.out.println(q.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1}));
    }
}
