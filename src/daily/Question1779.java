package daily;

import java.util.Arrays;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/12/1 9:33
 */
public class Question1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int idx = -1;
        int dis = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] != x && point[1] != y){
                continue;
            }
            int distance = Math.abs(point[0] - x) + Math.abs(point[1] - y);
            if (dis > distance){
                dis = distance;
                idx = i;
            }
        }

        return idx;
    }
}
