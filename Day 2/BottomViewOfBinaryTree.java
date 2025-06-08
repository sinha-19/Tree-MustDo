/*
 * Problem: Print bottom view of a binary tree.
 * Approach: Use level order traversal with horizontal distance tracking using a map.
 * Time: O(n), Space: O(n).
 */
import java.util.*;
public class BottomViewOfBinaryTree {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Map<Integer, Integer> map = new TreeMap<>(); // hd -> node value
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNode node = p.node;
            int hd = p.hd;
            map.put(hd, node.val); // overwrite to keep bottom node
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
