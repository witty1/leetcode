package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/6
 * @Time: 14:06
 * @Description: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        pre.next = head;
        while (temp.next.val != val){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return pre.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
