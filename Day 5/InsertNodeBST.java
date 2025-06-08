/*
 * Problem: Insert a value into BST.
 * Time: O(H), Space: O(H) due to recursion stack.
 */
class InsertNodeBST {
    public TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
}
