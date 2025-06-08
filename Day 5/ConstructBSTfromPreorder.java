/*
 * Problem: Construct BST from preorder traversal.
 * Time: O(n), Space: O(n)
 */
class ConstructBSTfromPreorder {
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }
    private TreeNode build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }
}
