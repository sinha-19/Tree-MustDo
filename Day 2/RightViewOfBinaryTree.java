/*
 * Problem: Print right view of binary tree.
 * Approach: Use DFS, track level, and add first node encountered at each level.
 * Time: O(n), Space: O(h).
 */
import java.util.*;
public class RightViewOfBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<Integer> rightView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (level == res.size()) res.add(root.val); // first node at this level
        dfs(root.right, level + 1, res);
        dfs(root.left, level + 1, res);
    }
}
