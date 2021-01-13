package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/11
 * @Time: 16:38
 * @Description: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 */
public class Offer33 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] postOrder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int i = left;
        //找到第一个大于根节点的索引，即右子树
        while (postOrder[i] < postOrder[right]) {
            i++;
        }
        int mid = i;
        //判断右子树的值是不是都大于根节点
        while (postOrder[i] > postOrder[right]) {
            i++;
        }
        //递归向下继续进行划分
        return i == right && recur(postOrder, left, mid - 1) && recur(postOrder, mid, right - 1);
    }
}
