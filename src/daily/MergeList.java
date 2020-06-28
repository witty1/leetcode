package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/28
 * @Time: 15:18
 * @Description: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
