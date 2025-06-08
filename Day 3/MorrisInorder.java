/*
 * Problem: Morris Inorder Traversal (O(1) space).
 * Approach: Thread predecessor, traverse in-order, remove thread.
 * Time: O(n), Space: O(1).
 */
public class MorrisInorder {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) pred = pred.right;
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
