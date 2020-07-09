package daily;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/9
 * @Time: 9:21
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class NAryTreePreorderTraversal {
    List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root==null){
            return list;
        }
        list.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return list;
    }

    class Node {
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
