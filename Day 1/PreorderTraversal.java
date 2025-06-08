import java.util.*;
public class PreorderTraversal {
    /*
     * Problem: Preorder Traversal of Binary Tree (Root-Left-Right)
     * Approach: Recursive traversal
     * Time: O(N), Space: O(H) [H=height of tree]
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }
    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.data);           // visit root
        dfs(node.left, res);          // visit left
        dfs(node.right, res);         // visit right
    }
}
