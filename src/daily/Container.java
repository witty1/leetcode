package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/14
 * @Time: 18:51
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 * 方法一：枚举
 * 方法二：双指针向中间收敛
 */
public class Container {
    public static int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int t = Math.min(height[i], height[j]) * (j - i);
                res = Math.max(t, res);
            }
        }

        return res;
    }

    public static int maxArea1(int[] height) {
        int res = 0;
        int j = height.length - 1;
        for (int i = 0; i < j; ) {
            int len = height[i]<height[j]?height[i++]:height[j--];
            int area = (j - i + 1) * len;
            res = Math.max(res, area);
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(maxArea1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
