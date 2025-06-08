/*
 * Problem: Find kth smallest element in BST.
 * Time: O(H + k), Space: O(H)
 */
class KthSmallestInBST {
    int count = 0, result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode node, int k) {
        if (node == null) return;
        inorder(node.left, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        inorder(node.right, k);
    }
}
