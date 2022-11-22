/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package array;

import java.util.HashMap;
import java.util.Optional;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/30 10:22
 * @description: https://leetcode-cn.com/problems/single-number/
 */
public class SingleNumber {
    /**
     * hashmap存储每个元素出现的次数，在最后找出value为1的元素即可
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v==null ? 1 : ++v);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1){
                return key;
            }
        }
        return 0;
    }

    /**
     * 异或；全0跟全1都为0，两个相同的数字进行异或运算结果一定为0
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
