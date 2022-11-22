package weekly.contest290;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/5/2 10:51
 */
public class Question290 {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for (int[] num : nums) {
            for (int i : num) {
                count[i]++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == nums.length) {
                res.add(i);
            }
        }
        return res;
    }

    public int countLatticePoints(int[][] circles) {
        int count = 0;
        int minX = 201, minY = 201, maxX = 0, maxY = 0;
        for (int[] circle : circles) {
            minX = Math.min(minX, circle[0] - circle[2]);
            minY = Math.min(minY, circle[1] - circle[2]);
            maxX = Math.max(maxX, circle[0] + circle[2]);
            maxY = Math.max(maxY, circle[1] + circle[2]);
        }
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int[] circle : circles) {
                    if ((circle[0] - x) * (circle[0] - x) + (circle[1] - y) * (circle[1] - y) <= circle[2] * circle[2]) {
                        count++;
                        break;
                    }
                }
            }
        }


        return count;
    }


    public static void main(String[] args) {
        Question290 question290 = new Question290();
        question290.countLatticePoints(new int[][]{{2, 2, 2}});
    }
}
