package hong.framework.ioc;

import java.util.ArrayDeque;
import java.util.Deque;


public class Main {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !deque.isEmpty()) {
            while (cur != null) {
                deque.addFirst(cur);
                cur = cur.left;
            }
            cur = deque.removeFirst();
            if (pre == p) {
                return cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return null;
    }
}
