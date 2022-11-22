/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package leetcode;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/7/27 19:55
 */
public class Leetcode2 {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode head = result;
        int carry;
        while (l1 != null || l2!=null){
            int temp = 0;
            if (l1 != null){
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                temp += l2.val;
                l2 = l2.next;
            }
            carry = temp / 10;
            result.val = temp % 10 + carry;
            result = result.next;
        }
        return head;
    }
}
