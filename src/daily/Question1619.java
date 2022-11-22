package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 * @since 2022/9/14 9:53
 */
public class Question1619 {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int num = (int) (arr.length * 0.05);
        for (int i = num; i < arr.length - num; i++){
            sum += arr[i];
        }
        return 1.0* sum / (arr.length - 2 * num);
    }
}
