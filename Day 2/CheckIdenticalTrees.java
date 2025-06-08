/*
 * Problem: Check if two binary trees are identical.
 * Approach: Recursively check both trees node by node.
 * Time: O(n), Space: O(h).
 */
public class CheckIdenticalTrees {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val && isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
