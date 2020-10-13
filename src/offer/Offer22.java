package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/13
 * @Time: 11:28
 * @Description: No Description
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode first = new ListNode(0);
        ListNode last = first;
        first.next = head;
        for (int i = 0; i < k; i++) {
            last = last.next;
        }
        while (last!=null){
            last = last.next;
            first = first.next;
        }
        return first;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
