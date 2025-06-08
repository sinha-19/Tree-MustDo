/*
 * Problem: Find diameter (longest path) of binary tree.
 * Approach: Use DFS to compute height and update max diameter at every node.
 * Time: O(n), Space: O(h).
 */
public class DiameterOfBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    private int maxDiameter = 0;
    public int diameter(TreeNode root) {
        height(root);
        return maxDiameter;
    }
    private int height(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
