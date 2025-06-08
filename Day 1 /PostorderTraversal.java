import java.util.*;
public class PostorderTraversal {
    /*
     * Problem: Postorder Traversal (Left-Right-Root)
     * Approach: Recursively visit left, right, then root
     * Time: O(N), Space: O(H)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        dfs(node.left, res);
        dfs(node.right, res);
        res.add(node.data);
    }
}
