/*
 * Problem: Maximum width of binary tree.
 * Approach: BFS with indexing nodes to calculate width per level.
 * Time: O(n), Space: O(n).
 */
public class MaxWidthBinaryTree {
    public int width(TreeNode root) {
        if (root == null) return 0;
        int max = 0;
        Deque<Pair> dq = new LinkedList<>();
        dq.offer(new Pair(root, 0));
        while (!dq.isEmpty()) {
            int size = dq.size();
            int left = dq.peek().idx;
            int right = left;
            for (int i = 0; i < size; i++) {
                Pair cur = dq.poll();
                right = cur.idx;
                if (cur.node.left != null)
                    dq.offer(new Pair(cur.node.left, 2 * cur.idx + 1));
                if (cur.node.right != null)
                    dq.offer(new Pair(cur.node.right, 2 * cur.idx + 2));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    static class Pair {
        TreeNode node; int idx;
        Pair(TreeNode n, int i) { node = n; idx = i; }
    }
}
