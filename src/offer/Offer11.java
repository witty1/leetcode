package offer;

import java.util.concurrent.locks.Condition;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/28
 * @Time: 16:38
 * @Description: No Description
 */
public class Offer11 {
    public int minArray(int[] numbers) {

        int left = 0,right = numbers.length - 1;
        while (left < right){
            int mid = left + right >> 1;
            if (numbers[mid] > numbers[right]){
                left = mid + 1;
            }else if (numbers[mid] < numbers[right]){
                right = mid - 1;
            }else {
                right --;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        System.out.println(new Offer11().minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
