package topInterview;




/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/11
 * @Time: 10:15
 * @Description: https://leetcode-cn.com/problems/add-two-numbers/
 */
@SuppressWarnings("all")
public class AddTwoNumbers {

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode next = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            next.next = new ListNode(sum % 10);
            next = next.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            next.next = new ListNode(1);
        }
        return head.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                s1.append(l1.val);
                l1 = l1.next;
            }
            if (l2 != null) {
                s2.append(l2.val);
                l2 = l2.next;
            }
        }
        int i = 0, j = 0;
        StringBuilder builder = new StringBuilder();
        int x = 0;
        while (i < s1.length() && j < s2.length()) {
            int value = Character.getNumericValue(s1.charAt(i++)) + Character.getNumericValue(s2.charAt(j++)) + x;
            if (value < 10) {
                x = 0;
                builder.append(value);
            } else {
                x = 1;
                builder.append(value % 10);
            }
        }

        while (i < s1.length()) {
            int value = Character.getNumericValue(s1.charAt(i++)) + x;
            if (value < 10) {
                x = 0;
                builder.append(value);
            } else {
                x = 1;
                builder.append(value % 10);
            }
        }
        while (j < s2.length()) {
            int value = Character.getNumericValue(s2.charAt(j++)) + x;
            if (value < 10) {
                x = 0;
                builder.append(value);
            } else {
                x = 1;
                builder.append(value % 10);
            }
        }
        if (x == 1) {
            builder.append(1);
        }
        i = 0;
        ListNode head = new ListNode(Character.getNumericValue(builder.charAt(i++)));
        ListNode tail = head;
        for (; i < builder.length(); i++) {
            ListNode temp = new ListNode(Character.getNumericValue(builder.charAt(i)));
            tail.next = temp;
            tail = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(1);
//        l2.next = new ListNode(9);
//        l2.next.next = new ListNode(9);
//        l2.next.next.next = new ListNode(9);
//        l2.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next = new ListNode(9);
//        l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
        addTwoNumbers(l1, l2);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
