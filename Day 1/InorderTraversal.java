import java.util.*;
public class InorderTraversal {
    /*
     * Problem: Inorder Traversal (Left-Root-Right)
     * Approach: Recursively visit left subtree, node, then right
     * Time: O(N), Space: O(H)
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        dfs(node.left, res);
        res.add(node.data);
        dfs(node.right, res);
    }
}
