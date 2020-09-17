package topInterview;

import java.util.Arrays;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/9/17
 * @Time: 12:58
 * @Description: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class Interview23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] listNodes, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            return listNodes[l];
        }
        int mid = (l + r) >> 1;
        return mergeTwoList(merge(listNodes, l, mid), merge(listNodes, mid + 1, r));
    }

    public static ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }
        temp.next = a == null ? b : a;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        ListNode[] listNodes = {a,b,c};
        mergeKLists(listNodes);
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
}
