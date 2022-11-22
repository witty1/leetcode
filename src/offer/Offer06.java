package offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/25
 * @Time: 11:02
 * @Description: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * 0 <= 链表长度 <= 10000
 */
public class Offer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode t = head;
        int len = 0;
        while (t != null) {
            t = t.next;
            len++;
        }
        int[] res = new int[len];
        int i = len - 1;
        while (head != null) {
            res[i--] = head.val;
            head = head.next;
        }
        return res;
    }

    public int[] reversePrint1(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        while (head != null) {
            deque.addFirst(head.val);
            head = head.next;
        }
        int[] res = new int[deque.size()];
        int index = 0;
        while (deque.size() > 0) {
            res[index++] = deque.removeFirst();
        }
        return res;
    }

    public int[] reversePrint2(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
           length++;
           temp = temp.next;
        }
        int[] res = new int[length];
        while (head!=null) {
            res[--length] = head.val;
            head = head.next;
        }
        return res;
    }

    int[] res;
    int length = 0;
    int index = 0;
    public int[] reversePrint3(ListNode head) {
        recur(head);
        return res;
    }

    public void recur(ListNode head){
        if (head == null){
            res = new int[length];
            return;
        }
        length++;
        recur(head.next);
        res[index++] = head.val;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
