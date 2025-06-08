/*
 * Problem: Find Minimum and Maximum value in a Binary Search Tree.
 * Approach: Minimum is the leftmost node, Maximum is the rightmost node.
 * Time: O(h), Space: O(1)
 */
public class FindMinMaxBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public int findMin(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Tree is empty");
        while (root.left != null) root = root.left;
        return root.val;
    }
    public int findMax(TreeNode root) {
        if (root == null) throw new IllegalArgumentException("Tree is empty");
        while (root.right != null) root = root.right;
        return root.val;
    }
}
