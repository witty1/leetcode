package design;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/qIsx9U/
 * @since 2023/1/22 13:18
 */
public class MovingAverage {

    private int cnt;
    private final int[] nums;
    private double sum;
    private int idx = -1;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
    }

    public double next(int val) {

        idx = (idx + 1) % nums.length;
        sum = sum - nums[idx] + val;
        if (cnt < nums.length){
            ++cnt;
        }
        nums[idx] = val;
        return sum / cnt;
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(3);
        System.out.println(movingAverage.next(1));
    }
}
