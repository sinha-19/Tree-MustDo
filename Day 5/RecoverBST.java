/*
 * Problem: Recover BST where 2 nodes are swapped.
 * Approach: Inorder traversal to find misplaced nodes.
 * Time: O(n), Space: O(h) for recursion.
 */
class RecoverBST {
    TreeNode first, second, prev;
    public void recoverTree(TreeNode root) {
        first = second = prev = null;
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) first = prev;
            second = root;
        }
        prev = root;
        inorder(root.right);
    }
}
