package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/2
 * @Time: 8:27
 * @Description: https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    Object[] obj = new Object[16];
    int min = Integer.MAX_VALUE;
    int size = 0;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (size == obj.length-1) {
            Object[] temp = new Object[size * 2];
            System.arraycopy(obj, 1, temp, 1, size);
            obj = temp;
        }
        obj[++size] = x;
        if (x <= min) {
            min = x;
        }
    }

    public void pop() {
        obj[size--] = null;
        if (size > 0)
            min();
        else
            min = Integer.MAX_VALUE;
    }

    public int top() {
        return (int) obj[size];
    }

    public int getMin() {
        return min;
    }

    public void min() {
        int x = Integer.MAX_VALUE;
        for (int i = 1; i <= size; i++) {
            if ((int) obj[i] <= x) {
                x = (int) obj[i];
            }
        }
        min = x;
    }
}
