/*
 * Problem: Check if binary tree is a BST.
 * Time: O(n), Space: O(n)
 */
class CheckIfBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
