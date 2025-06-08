/*
 * Problem: Check if tree is height balanced.
 * Approach: Postorder traversal returning height and checking balance at every node.
 * Time: O(n), Space: O(h).
 */
public class CheckHeightBalanced {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
