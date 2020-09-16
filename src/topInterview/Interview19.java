package topInterview;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/16
 * @Time: 16:23
 * @Description: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class Interview19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode fast = first,slow = first;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return first.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int size = 0;
        while (temp!=null){
            size++;
            temp = temp.next;
        }
        temp = head;
        while (true){
            if (size == n){
                return head.next;
            }
            if (--size == n){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
