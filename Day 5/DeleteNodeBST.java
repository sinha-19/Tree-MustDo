/*
 * Problem: Delete a node in BST.
 * Time: O(H), Space: O(H)
 */
class DeleteNodeBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode minNode = getMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
