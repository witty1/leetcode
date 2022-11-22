package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author wit
 * @version V2.1
 * @since 2021/11/21 10:15
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class MaximumDepthOfNAryTree {
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
    int maxDepth = 0;
    public int maxDepth(Node root) {
        if (root == null){
            return maxDepth;
        }
        maxDepth = recur(root, 0);
        return maxDepth;
    }

    public int recur(Node root, int index){
        if (root == null){
            maxDepth = Math.max(maxDepth, index);
            return maxDepth ;
        }
        for (Node child : root.children) {
            maxDepth = Math.max(recur(child, ++index), maxDepth);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        LinkedList<Node> list = new LinkedList<>();
        LinkedList<Node> last = new LinkedList<>();
        Node mid = new Node(3);
//        last.addLast();
        list.addLast(mid);
        list.addLast(new Node(2));
        list.addLast(new Node(4));
        node.children = list;
    }
}
