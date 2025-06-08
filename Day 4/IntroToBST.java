/*
 * Problem: Introduction to Binary Search Tree (BST)
 * Approach: Theory-based – Understand how BST works and its properties.
 * Note: For implementation, we provide basic BST class with insert and in-order traversal.
 * Time: O(log n) avg for insert/search, Space: O(h)
 */
public class IntroToBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }
}
