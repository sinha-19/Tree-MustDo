import java.util.*;
public class PostorderOneStack {
    /*
     * Problem: Postorder using 1 Stack
     * Approach: Use single stack & previous node tracking
     * Time: O(N), Space: O(N)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.peek();
                if (node.right != null && node.right != prev) {
                    curr = node.right;
                } else {
                    res.add(node.data);
                    prev = node;
                    stack.pop();
                }
            }
        }
        return res;
    }
}
