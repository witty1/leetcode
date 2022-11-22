package daily;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/maximum-number-of-eaten-apples/
 * @since 2021/12/24 16:57
 */
public class Question1705 {
    int ans = 0;
    int day = 1;
    public int eatenApples(int[] apples, int[] days) {
        //apples = [1,2,3,5,2], days = [3,2,1,4,2]
        // queue  int[]:day:apple
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int length = apples.length;
        int i = 0;
        while (i < length) {
            if (apples[i] > 0) {
                int[] peek = queue.peek();
                if (peek != null && days[i] + i == peek[0]) {
                    peek = queue.poll();
                    queue.add(new int[]{peek[0], peek[1] + apples[i]});
                } else {
                    queue.add(new int[]{i + days[i], apples[i]});
                    System.out.println("添加" + days[i] + "天" + apples[i] + "个苹果");
                }

            }
            sub(queue, i);
            i++;
        }
        while (!queue.isEmpty()) {
            sub(queue, i++);
        }
        return ans;
    }

    public void sub(PriorityQueue<int[]> queue, int i) {
        int[] peek = queue.poll();
        if (peek != null) {
            ans++;
            if (--peek[1] != 0 && peek[0] != ++i) {
                queue.add(new int[]{peek[0], peek[1]});
            }else {
                System.out.println("第" + peek[0] + "天已被移除" + peek[1]);
            }

        }
    }

    public static void main(String[] args) {
        //[1,10,17,10,12,6,20,8,8,22,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,5,2,1,0,0,0,0,0,0,23]
        //[19999,11,18,22,5,2,14,5,20,7,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,2,1,4,2,7,0,0,0,0,0,0,1]
        System.out.println(new Question1705().eatenApples(new int[]{1,10,17,10,12,6,20,8,8,22,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,5,2,1,0,0,0,0,0,0,23}, new int[]{19999,11,18,22,5,2,14,5,20,7,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,2,1,4,2,7,0,0,0,0,0,0,1}));
    }
}
