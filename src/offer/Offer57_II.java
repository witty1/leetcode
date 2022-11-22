package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/31
 * @Time: 17:10
 * @Description: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 */
public class Offer57_II {
    /**
     * 暴力枚举
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new LinkedList<>();
        for (int i = 1; i <= target / 2; i++) {
            List<Integer> temp = new LinkedList<>();
            int count = 0;
            for (int j = i; j <= target; j++) {
                temp.add(j);
                count += j;
                if (count == target) {
                    list.add(temp.stream().mapToInt(k -> k).toArray());
                    break;
                } else if (count > target) {
                    break;
                }
            }
        }


        return list.toArray(new int[list.size()][]);
    }

    /**
     * 滑动窗口
     * @param target
     * @return
     */
    public int[][] findContinuousSequence1(int target) {
        List<int[]> res = new LinkedList<>();
        int j = 1, i = 1, count = 0;
        while (i <= target / 2) {
            if (count < target) {
                count += j;
                j++;
            } else if (count > target) {
                count -= i;
                i++;
            } else {
                int[] temp = new int[j - i];
                for (int k = i; k < j; k++) {
                    temp[k - i] = k;
                }
                res.add(temp);
                count -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(9 / 2);
        new Offer57_II().findContinuousSequence1(9);
    }
}
