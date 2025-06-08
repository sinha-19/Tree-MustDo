import java.util.*;
public class IterativeInorder {
    /*
     * Problem: Iterative Inorder Traversal
     * Approach: Use stack to simulate recursion
     * Time: O(N), Space: O(N)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            // Reach the left most node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();              // Visit node
            res.add(curr.data);
            curr = curr.right;              // Move to right subtree
        }
        return res;
    }
}
