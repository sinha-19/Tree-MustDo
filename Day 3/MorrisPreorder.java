/*
 * Problem: Morris Preorder Traversal (O(1) extra space).
 * Approach: Create threads to predecessors and remove them after use.
 * Time: O(n), Space: O(1).
 */
public class MorrisPreorder {
    public List<Integer> preorder(TreeNode root) {
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
                    res.add(curr.val);
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    pred.right = null;
                    curr = curr.right;
                }
            }
        }
        return res;
    }
}
