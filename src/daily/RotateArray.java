package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/27
 * @Time: 9:52
 * @Description: https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] temp = new int[nums.length];
        for (int i=0;i<nums.length;i++){
            temp[(i+k)%nums.length] = nums[i];
        }
        for (int i=0;i<nums.length;i++){
            nums[i] = temp[i];
        }
    }

    public void ratate1(int[] nums,int k){
        int temp,pre;
        for (int i=0;i<k;i++){
            pre = nums[nums.length-1];
            for (int j= 0;j<nums.length;j++){
                temp = nums[j];
                nums[j] = pre;
                pre = temp;
            }
        }
    }


}
