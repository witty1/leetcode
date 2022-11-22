package question;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/3/22
 * @Time: 10:14
 * @Description: No Description
 */
public class Question206 {
    /**
     * 递归解法
     */
    class Solution {
        ListNode pre,newHead;
        public ListNode reverseList(ListNode head) {
            reverse(head);
            return newHead;
        }

        public void reverse(ListNode head){
            if(head == null){
                return;
            }
            newHead = head;
            reverse(head.next);
            if(pre != null){

                pre.next = head;
                head.next = null;
            }
            pre = head;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = head,pre = null;
        while (newHead!=null){
            ListNode next = newHead.next;
            newHead.next = pre;
            pre = newHead;
            newHead = next;
        }
        return newHead;
    }



    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
