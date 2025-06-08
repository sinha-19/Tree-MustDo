/*
 * Problem: Find maximum path sum in binary tree.
 * Approach: DFS, return max gain from each node, update max sum path considering left+right+node.
 * Time: O(n), Space: O(h).
 */
public class MaximumPathSum {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(dfs(node.left), 0);
        int right = Math.max(dfs(node.right), 0);
        maxSum = Math.max(maxSum, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
