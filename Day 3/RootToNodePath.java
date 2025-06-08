/*
 * Problem: Find path from root to target node in a binary tree.
 * Approach: DFS with backtracking: track current path, return when target found.
 * Time: O(n), Space: O(h).
 */
public class RootToNodePath {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    public List<Integer> path(TreeNode root, int target) {
        List<Integer> res = new ArrayList<>();
        if (root != null && dfs(root, target, res)) return res;
        return Collections.emptyList();
    }
    private boolean dfs(TreeNode node, int target, List<Integer> res) {
        if (node == null) return false;
        res.add(node.val);
        if (node.val == target
         || dfs(node.left, target, res)
         || dfs(node.right, target, res))
            return true;
        res.remove(res.size() - 1);
        return false;
    }
}
