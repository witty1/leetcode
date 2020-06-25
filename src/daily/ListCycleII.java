package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/25
 * @Time: 11:10
 * @Description: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class ListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if (fast==null||fast.next==null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        fast = head;
        while (slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
