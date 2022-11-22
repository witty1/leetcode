/*
 * yunrong.cn Inc. Copyright (c) 2014-2021 All Rights Reserved
 */

package weekly.contest265;

import java.util.HashMap;

/**
 * TODO
 *
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @since 2021/10/31 12:36
 */
public class Question5915 {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1, -1};
        if (head == null) {
            return res;
        }
        int min = Integer.MAX_VALUE, minDistance = -1, maxDistance = -1;
        ListNode temp = head.next;
        Integer pre = head.val, now = null, next = null;
        while (head.next != null) {

        }
        return res;
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
