package offer;

/**
 * @Created with IntelliJ IDEA.
 * @author: wit
 * @Date: 2021/1/13
 * @Time: 11:14
 * @Description: No Description
 */
public class Offer36 {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root == null){
            return null;
        }
        dfs(root);
        //设置头尾指针
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void dfs(Node node){
        if (node == null){
            return;
        }
        dfs(node.left);
        //当前驱节点为空时代表这是头结点，否则设置前驱节点的right指针为当前节点
        if (pre == null){
            head = node;
        }else {
            pre.right = node;
        }
        //设置当前节点的left节点为pre节点
        node.left = pre;
        pre = node;
        dfs(node.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
