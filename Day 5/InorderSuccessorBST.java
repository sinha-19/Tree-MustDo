/*
 * Problem: Inorder Successor in BST.
 * Time: O(H), Space: O(1)
 */
class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while (root != null) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else root = root.right;
        }
        return successor;
    }
}
