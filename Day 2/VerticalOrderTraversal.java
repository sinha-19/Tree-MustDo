/*
 * Problem: Vertical order traversal of binary tree.
 * Approach: Use BFS with horizontal distance and store nodes in TreeMap.
 * Time: O(n), Space: O(n).
 */
import java.util.*;
public class VerticalOrderTraversal {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            map.computeIfAbsent(hd, x -> new ArrayList<>()).add(node.val);
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }
        for (List<Integer> list : map.values()) res.add(list);
        return res;
    }
    static class Pair {
        TreeNode node; int hd;
        Pair(TreeNode n, int h) { node = n; hd = h; }
    }
}
