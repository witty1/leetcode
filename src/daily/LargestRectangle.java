package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/3
 * @Time: 15:56
 * @Description: https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            while (left > 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            int right = i;
            while (right < heights.length - 1 && heights[right+1] >= heights[i]) {
                right++;
            }
            int width = right-left+1;
            max = Integer.max(max, heights[i]*width);
        }
        return max;
    }
}
