import java.util.*;
public class SpiralLevelOrderTraversal {
    /*
     * Problem: Zigzag (Spiral) Level Order
     * Approach: Use Deque or reverse level list on odd levels
     * Time: O(N), Space: O(N)
     */
    public List<List<Integer>> spiralOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (leftToRight)
                    level.addLast(node.data);
                else
                    level.addFirst(node.data);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }
}
