/*
 * Problem: Search in a Binary Search Tree.
 * Approach: Use BST property (left < root < right) to search recursively or iteratively.
 * Time: O(log n) avg, O(n) worst; Space: O(h) recursive, O(1) iterative.
 */
public class SearchInBST {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }
    public TreeNode searchBST(TreeNode root, int target) {
        if (root == null || root.val == target) return root;
        return target < root.val
            ? searchBST(root.left, target)
            : searchBST(root.right, target);
    }
}
