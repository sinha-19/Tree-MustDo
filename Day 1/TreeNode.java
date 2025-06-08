/**
 * Problem: Basic node representation for binary tree.
 * Approach: Define `TreeNode` class with int value, left/right pointers.
 * Time/Space: O(1) per node creation.
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
