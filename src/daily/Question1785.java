package daily;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/problems/minimum-elements-to-add-to-form-a-given-sum/
 * @since 2022/12/16 22:48
 */
public class Question1785 {
    public static int minElements(int[] nums, int limit, int goal) {
        long sum = goal;
        for (int num : nums) {
            sum -= num;
        }
        int ans = 0;
        if (sum != 0){
            long multiple = Math.floorDiv(Math.abs(sum), limit);
            if (sum > 0){
                if (multiple > 0){
                    ans += multiple;
                    sum -= multiple * limit;
                }

            }else {
                if (multiple > 0){
                    ans += multiple;
                    sum += multiple * limit;
                }
            }
            if (sum != 0){
                return ++ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minElements(new int[]{1000000, 1000000, 1000000}, 1000000, -1000000000));
    }
}
