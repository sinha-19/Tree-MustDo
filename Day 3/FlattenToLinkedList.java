/*
 * Problem: Flatten binary tree to linked list in-place.
 * Approach: Recursively flatten subtrees; rewire pointers to next-right chain.
 * Time: O(n), Space: O(h).
 */
public class FlattenToLinkedList {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
