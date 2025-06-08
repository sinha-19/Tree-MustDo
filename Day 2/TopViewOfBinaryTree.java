/*
 * Problem: Top view of binary tree.
 * Approach: BFS traversal with horizontal distance, record first node at each hd.
 * Time: O(n), Space: O(n).
 */
import java.util.*;
public class TopViewOfBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<Integer> topView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }
        for (int val : map.values()) res.add(val);
        return res;
    }
    static class Pair {
        TreeNode node; int hd;
        Pair(TreeNode n, int h) { node = n; hd = h; }
    }
}
