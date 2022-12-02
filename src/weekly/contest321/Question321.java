package weekly.contest321;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author zhengcp25979@yunrong.cn
 * @version V2.1
 * @description https://leetcode.cn/contest/weekly-contest-321/
 * @since 2022/11/27 10:57
 */
public class Question321 {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int pre = 1;
        for (int i = 1; i < n; i++) {
            if (pre == sum){
                return i;
            }
            pre += i + 1;
            sum -= pre;
        }
        return -1;
    }

    public int appendCharacters(String s, String t) {
        char[] source = s.toCharArray();
        char[] target = t.toCharArray();
        int j = 0;
        for (int i = 0; i < source.length && j < target.length; i++) {
            if (source[i] == target[j]){
                j++;
            }
        }
        return target.length - j;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode tempHead = head;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        while (head != null){
            if (deque.isEmpty() || deque.getLast() >= head.val){
                deque.add(head.val);
            }else {
                while (!deque.isEmpty() && deque.getLast() < head.val){
                    deque.removeLast();
                }
                deque.addLast(head.val);
            }
            head = head.next;
        }
        for (Integer integer : deque) {

        }

        return ans;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        Question321 question321 = new Question321();
        System.out.println(question321.pivotInteger(8));
    }
}
