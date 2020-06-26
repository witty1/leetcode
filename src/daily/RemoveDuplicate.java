package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/26
 * @Time: 10:07
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 */
public class RemoveDuplicate {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)
            return 0;
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
