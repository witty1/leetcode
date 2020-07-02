package daily;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/30
 * @Time: 9:26
 * @Description: https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i]%10;
            if (digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
