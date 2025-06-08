/*
 * Problem: Find size of largest BST in a binary tree.
 * Approach: Post-order traversal with subtree info.
 * Time: O(n), Space: O(n)
 */
class LargestBSTinBT {
    class NodeInfo {
        int size, min, max;
        boolean isBST;
        NodeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    int maxBST = 0;
    public int largestBSTSubtree(TreeNode root) {
        helper(root);
        return maxBST;
    }
    private NodeInfo helper(TreeNode node) {
        if (node == null) return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        NodeInfo left = helper(node.left);
        NodeInfo right = helper(node.right);
        if (left.isBST && right.isBST && node.val > left.max && node.val < right.min) {
            int size = left.size + right.size + 1;
            maxBST = Math.max(maxBST, size);
            return new NodeInfo(size, Math.min(node.val, left.min), Math.max(node.val, right.max), true);
        }
        return new NodeInfo(0, 0, 0, false);
    }
}
