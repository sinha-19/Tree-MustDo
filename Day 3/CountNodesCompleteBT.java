/*
 * Problem: Count nodes in a complete binary tree.
 * Approach: Use left/right subtree heights. If equal, left is perfect; else recurse, totaling O(log^2 n).
 * Time: O(log^2 n), Space: O(log n).
 */
public class CountNodesCompleteBT {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = leftHeight(root), rh = rightHeight(root);
        if (lh == rh) {
            return (1 << lh) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
    private int leftHeight(TreeNode node) {
        int h = 0;
        while (node != null) { h++; node = node.left; }
        return h;
    }
    private int rightHeight(TreeNode node) {
        int h = 0;
        while (node != null) { h++; node = node.right; }
        return h;
    }
}
