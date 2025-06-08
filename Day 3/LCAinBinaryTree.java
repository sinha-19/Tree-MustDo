/*
 * Problem: Lowest Common Ancestor in binary tree.
 * Approach: DFS returns node if matches, else find in left/right and combine.
 * Time: O(n), Space: O(h).
 */
public class LCAinBinaryTree {
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }
}
