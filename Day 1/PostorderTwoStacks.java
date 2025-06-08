import java.util.*;
public class PostorderTwoStacks {
    /*
     * Problem: Post-order Traversal using 2 stacks
     * Approach: First stack to simulate tree traversal, second to reverse order
     * Time: O(N), Space: O(N)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
        while (!s2.isEmpty()) {
            res.add(s2.pop().data);
        }
        return res;
    }
}
