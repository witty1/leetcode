package offer;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/12/9
 * @Time: 19:57
 * @Description: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Offer39 {
    //二分
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    //哈希表
    public int s(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length ;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num)*2 > n) {
                return num;
            }
        }
        return 0;
    }

    //摩尔计数法
    public int s1(int[] nums){
        int res=0,vote = 0;
        for (int num : nums) {
            if (vote==0){
                res = num;
            }
            vote += res == num?1:-1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer39 offer39 = new Offer39();
        System.out.println(offer39.s1(new int[]{1,1,2}));
    }
}
