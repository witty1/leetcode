package weekly.contest279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/sort-even-and-odd-indices-independently/
 * @since 2022/2/7 17:00
 */
public class Question6000 {
    public int[] sortEvenOdd(int[] nums) {

        ArrayList<Integer> odd = new ArrayList<>(nums.length >> 1);
        ArrayList<Integer> even = new ArrayList<>(nums.length >> 1);
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even.add(nums[i]);
            } else {
                odd.add(nums[i]);
            }
        }
        odd.sort((o1, o2) -> o2 - o1);
        even.sort(Comparator.comparingInt(o -> o));
        int inc = 0, dec = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = even.get(inc++);
            } else {
                nums[i] = odd.get(dec++);
            }
        }
        return nums;
    }

    public int[] sortEvenOdd1(int[] nums) {
        int[] odd = new int[nums.length >> 1];
        int[] even = new int[nums.length + 1 >> 1];
        int oddIdx = 0, evenIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                even[evenIdx++] = nums[i];
            } else {
                odd[oddIdx++] = nums[i];
            }
        }
        Arrays.sort(odd);
        Arrays.sort(even);
        oddIdx = odd.length - 1;
        evenIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 0) {
                nums[i] = even[evenIdx++];
            } else {
                nums[i] = odd[oddIdx--];
            }
        }
        return nums;
    }


    public static void main(String[] args) {
    }

}
