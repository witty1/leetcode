package weekly.contest272;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/12/22 17:28
 * @description: https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-k-increasing/
 */
public class Question2111 {
    //[12,6,12,6,14,2,13,17,3,8,11,7,4,11,18,8,8,3]
    //1
    public int kIncreasing(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i + k < arr.length; i++) {
            if (arr[i] > arr[i + k]){
                count++;
            }
        }
        return count;
    }
}
