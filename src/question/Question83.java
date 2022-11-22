package question;

/**
 * TODO
 *
 * @author zhengcp25979
 * @version V2.1
 * @since 2021/11/22 9:50
 * @description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 83. 删除排序链表中的重复元素
 */
public class Question83 {
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tempHead = head;
        while (tempHead.next != null) {
            if (tempHead.next.val == tempHead.val){
                tempHead.next = tempHead.next.next;
            }else {
                tempHead = tempHead.next;
            }
        }
        return head;
    }
}
