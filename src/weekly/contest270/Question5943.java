package weekly.contest270;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description: https://leetcode-cn.com/problems/delete-the-middle-node-of-a-linked-list/
 * @since 2021/12/5 10:30
 */
public class Question5943 {

    public static ListNode deleteMiddle1(ListNode head) {
        if (head.next == null){
            return null;
        }
        ListNode fast = head,slow = head,pre = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return head;
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next!= null) {
            length++;
            temp = temp.next;
        }

        ListNode cur = head;
        ListNode pre = cur;
        length = length >> 1;
        while (length > 0) {
            pre = cur;
            cur = cur.next;
            length--;
        }
        if (cur != null){
            cur = cur.next;
        }
        pre.next = cur;
        return head;
    }

    static class ListNode {
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


    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        node.next = new ListNode(2);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
        deleteMiddle(node);
    }
}
