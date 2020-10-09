package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/9
 * @Time: 15:49
 * @Description: No Description
 */
public class Offer15 {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            n &= (n-1);
            count ++;
        }
        return count;
    }

}
