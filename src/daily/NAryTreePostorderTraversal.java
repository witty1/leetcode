package daily;

import java.util.LinkedList;
import java.util.List;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2020/7/9
 * @Time: 9:28
 * @Description: https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NAryTreePostorderTraversal {
    List<Integer> list = new LinkedList<>();
    public List<Integer> postorder(Node root) {
        if (root==null){
            return list;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        list.add(root.val);
        return list;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
