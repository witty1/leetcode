package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/23
 * @Time: 19:12
 * @Description: https://leetcode-cn.com/problems/swap-nodes-in-pairs/submissions/
 */
public class SwapNodes {
    public  ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode cur = head;
        ListNode newHead = head.next;
        while(cur!=null && cur.next!=null){
            ListNode temp = cur;
            cur = cur.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
            if(cur!=null&&cur.next!=null){
                temp.next = cur.next;
            }

        }
        return newHead;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
