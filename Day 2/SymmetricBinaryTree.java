/*
 * Problem: Check if binary tree is symmetric.
 * Approach: Recursively compare left and right subtree for mirror equality.
 * Time: O(n), Space: O(h).
 */
public class SymmetricBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return (a.val == b.val) && isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}
