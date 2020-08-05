package daily;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/6/22
 * @Time: 9:29
 * @Description: 反转列表https://leetcode-cn.com/problems/reverse-linked-list/submissions/
 * 双指针迭代
 */
public class RevereList {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur=head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}