import java.util.*;
public class IterativePreorder {
    /*
     * Problem: Iterative Preorder Traversal
     * Approach: Use Stack to simulate recursion
     * Time: O(N), Space: O(N)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.data);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
        return res;
    }
}
