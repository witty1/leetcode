package weekly.contest280;

import java.util.Arrays;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/2/13 11:43
 */
public class Question6006 {
    public long minimumRemoval(int[] beans) {
        if (beans.length <= 1) {
            return 0;
        }
        Arrays.sort(beans);
        long res = 0;
        int mid = beans.length - 1 >> 1;
        long temp = 0;
        int max = beans[beans.length - 1];
        for (int i = 0; i < beans.length; i++) {
            if (i < mid && beans[i] != beans[mid]) {
                res += beans[i];
            } else if (i > mid && beans[i] != beans[mid]) {
                res += beans[i] - beans[mid];
            }
            if (beans[i] != max){
                temp += beans[i];
            }
        }
        return Math.min(res, temp);
    }
}
