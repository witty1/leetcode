package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/9/22 9:19
 */
public class Question1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] count = new int[101];
        for (int i = 0; i < pieces.length; i++) {
            count[pieces[i][0]] = i;
        }
        for (int i = 0; i < arr.length; ) {
            int idx = count[arr[i]];
            int len = pieces[idx].length;
            for (int j = 0; j < len; j++) {
                if (pieces[idx][j] != arr[i + j]) {
                    return false;
                }
            }
            i = i + len;
        }
        return true;
    }
}
