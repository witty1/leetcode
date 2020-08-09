package divide;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/9
 * @Time: 8:34
 * @Description: No Description
 */
public class MajorityElement {
    //排序法
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>2];
    }
    //摩尔计数法
    public int majorityElement1(int[] nums) {
       int card = nums[0],count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==card){
                ++count;
            } else if (--count==0){
                count = 1;
                card = nums[i];
            }
        }
        return card;
    }
}
