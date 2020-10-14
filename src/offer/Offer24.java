package offer;


/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/14
 * @Time: 9:56
 * @Description: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre;
            pre = pre.next;
            t.next = cur;
            cur = t;
        }
        return cur;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
