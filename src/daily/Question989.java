package daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/22
 * @Time: 11:50
 * @Description: https://leetcode-cn.com/problems/add-to-array-form-of-integer/
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * 示例 2：
 * <p>
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * 如果 A.length > 1，那么 A[0] != 0
 */
public class Question989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int num = K % 10;
            int temp = A[i] + num + carry;
            A[i] = temp % 10;
            carry = temp / 10;
            K /= 10;
        }
        while (K != 0) {
            int i = K % 10;
            K /= 10;
            int t = carry + i;
            carry = t / 10;
            list.addFirst(t % 10);
        }
        for (int value : A) {
            if (carry == 1) {
                list.addFirst(carry);
                carry = 0;
            }
            list.add(value);
        }
        return list;
    }

    public List<Integer> addToArrayForm1(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        //将每位相加的结果保存到K中
        for (int i = A.length - 1; i >= 0 || K > 0; i--, K /= 10) {
            if (i >= 0) {
                K += A[i];
            }
            list.addFirst(K % 10);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new Question989().addToArrayForm(new int[]{9, 9}, 999999);
        list.forEach(System.out::print);
        System.out.println();
        int x = 9 / 10;
        System.out.println(x);
    }
}
