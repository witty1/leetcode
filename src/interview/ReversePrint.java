package interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/8/13
 * @Time: 14:21
 * @Description: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        recursion(head,list);
        int[] res = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop().val;
        }
        return res;
    }

    public void recursion(ListNode head,List<Integer> list){
        if (head==null){
            return;
        }
        recursion(head.next, list);
        list.add(head.val);
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
