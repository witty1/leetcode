/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package array;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/30 10:50
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int amount = 0;
            for (int num : nums) {
                amount += (num >> i) & 1;
            }
            if (amount % 3 != 0){
                res |= (1 <<i);
            }
        }
        return res;
    }
}
