package weekly.contest269;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/11/30 15:41
 * @description: https://leetcode-cn.com/contest/weekly-contest-269/problems/removing-minimum-and-maximum-from-array/
 */
public class Question2091 {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE,maxPos = 0,min = Integer.MAX_VALUE,minPos = 0;
        //确定最大最小值位置
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max){
                max = nums[i];
                maxPos = i +1;
            }
            if (nums[i] < min){
                min = nums[i];
                minPos = i + 1;
            }
        }
        //最大值到右边的距离
        int maxRightDistance = len - maxPos + 1;
        //最小值到右边的距离
        int minRightDistance = len - minPos + 1;
        //最小、最大值到左边的最远距离
        int maxLeftDis = Math.max(maxPos, minPos);
        //最小、最大值到右边的最大距离
        int maxRightDis = Math.max(maxRightDistance, minRightDistance);
        int res = Math.min(maxLeftDis, maxRightDis);
        //最小值到左边-最大值到右边
        int l = minPos + maxRightDistance;
        //最大值到左边，最小值到右边
        int m = minRightDistance + maxPos;
        int r = Math.min(l, m);
        return Math.min(res, r);
    }
}
