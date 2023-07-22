package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/10/4
 * @Time: 14:53
 * @Description: https://leetcode-cn.com/problems/add-two-numbers/submissions/
 */
public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int left = 0;
        ListNode ans = new ListNode();
        ListNode next = ans;
        while (l1 != null || l2 != null) {
            int temp = 0;
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }
            temp += left;
            left = temp / 10;
            temp = temp % 10;
            next.next = new ListNode(temp);
            next = next.next;
        }
        if (left != 0) {
            next.next = new ListNode(left);
        }
        return ans.next;
    }


    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int x = 0;
        ListNode next = new ListNode(0);
        ListNode t2 = new ListNode(0);
        next.next = l1;
        t2.next = l2;
        while (next.next != null && t2.next != null) {
            next = next.next;
            t2 = t2.next;
            int res = next.val + t2.val + x;
            x = res / 10;
            next.val = res % 10;
        }
        next.next = next.next == null ? t2.next : next.next;
        while (next.next != null) {
            next = next.next;
            int res = next.val + x;
            x = res / 10;
            next.val = res % 10;
        }
        if (x != 0) {
            next.next = new ListNode(1);
        }
        return l1;
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
