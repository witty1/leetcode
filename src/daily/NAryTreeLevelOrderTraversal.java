package daily;

import java.util.*;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/9
 * @Time: 9:36
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NAryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root==null){
            return lists;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                queue.addAll(poll.children);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.children = Arrays.asList(new Node(3,Arrays.asList(new Node(5),new Node(6))),new Node(2),new Node(4));
        levelOrder(node);
    }



    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
