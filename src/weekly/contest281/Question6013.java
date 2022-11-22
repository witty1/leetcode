package weekly.contest281;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description
 * @since 2022/2/20 10:37
 */
public class Question6013 {
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

    public ListNode mergeNodes(ListNode head) {
        ListNode res = new ListNode();
        ListNode next = res;
        int val = 0;
        head = head.next;
        while (head!= null){
            if (head.val == 0){
                if (val != 0){
                    if (next.val == 0){
                        next.val = val;

                    }else {
                        next.next = new ListNode(val);
                        next = next.next;

                    }
                    val = 0;
                }
            }
            val += head.val;
            head = head.next;

        }
        return res;
    }
}
