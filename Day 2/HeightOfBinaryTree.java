/*
 * Problem: Calculate height of binary tree.
 * Approach: Recursively find height of left and right subtree and return max + 1.
 * Time: O(n), Space: O(h) for recursion stack.
 */
class TreeNode {
    int val; TreeNode left, right;
    TreeNode(int val) { this.val = val; left = right = null; }
}
public class HeightOfBinaryTree {
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
