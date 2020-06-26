package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/24
 * @Time: 20:50
 * @Description: 141.h=环形列表https://leetcode-cn.com/problems/linked-list-cycle/submissions/
 * 快慢指针
 */
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        while (fast != head) {
            if (fast == null || fast.next == null) {
                return false;
            }
            head = head.next;
            fast = fast.next.next;
        }
        return true;
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
