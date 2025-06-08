/*
 * Problem: Zig Zag (spiral) traversal of binary tree.
 * Approach: Use deque and toggle direction each level.
 * Time: O(n), Space: O(n).
 */
import java.util.*;
public class ZigZagTraversal {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        boolean leftToRight = true;
        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (leftToRight) {
                    TreeNode node = dq.pollFirst();
                    level.add(node.val);
                    if (node.left != null) dq.offerLast(node.left);
                    if (node.right != null) dq.offerLast(node.right);
                } else {
                    TreeNode node = dq.pollLast();
                    level.add(node.val);
                    if (node.right != null) dq.offerFirst(node.right);
                    if (node.left != null) dq.offerFirst(node.left);
                }
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
