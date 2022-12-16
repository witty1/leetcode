package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 * @since 2022/12/2 15:16
 */
public class Question1769 {
    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (i == j || boxes.charAt(j) == '0') {
                    continue;
                }
                cnt += Math.abs(i - j);
            }
            ans[i] = cnt;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }


    //0 1 1
    //0 1 2 3 4 5
    //3 1 1
    public int[] minOperations1(String boxes) {
        int left = boxes.charAt(0) - '0';
        int right = 0;
        int operation = 0;
        for (int i = 1; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1'){
                operation += i;
                right++;
            }
        }
        int[] ans = new int[boxes.length()];
        ans[0] = operation;
        for (int i = 1; i < boxes.length(); i++) {
            operation += left - right;
            if (boxes.charAt(i) == '1'){
                left++;
                right--;
            }
            ans[i] = operation;
        }
        return ans;
    }
}
