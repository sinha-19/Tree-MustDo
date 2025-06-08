/*
 * Problem: Check children sum property in a binary tree.
 * Approach: Recursively confirm node value equals sum of children's values.
 * Time: O(n), Space: O(h).
 */
public class ChildrenSumProperty {
    public boolean isValid(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return true;
        int sum = 0;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;
        return root.val == sum
            && isValid(root.left)
            && isValid(root.right);
    }
}
