package weekly.contest277;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2022/1/23 10:47
 */
public class Question5991 {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int[] res = new int[length];
        int positive = 0, negative = 0, i = 0;
        while (true) {
            if (i == length) {
                break;
            }
            if ((i & 1) == 0) {
                while (nums[positive] < 0) {
                    positive++;
                }
                res[i++] = nums[positive++];
            } else {
                while (nums[negative] > 0) {
                    negative++;
                }
                res[i++] = nums[negative++];
            }
        }
        return res;
    }
}
