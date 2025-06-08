/*
 * Problem: Boundary traversal of binary tree.
 * Approach: Print left boundary, leaf nodes, and right boundary without duplicates.
 * Time: O(n), Space: O(h).
 */
import java.util.*;
public class BoundaryTraversal {
    static class TreeNode {
        int val; TreeNode left, right;
        TreeNode(int v) { val = v; left = right = null; }
    }
    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        printLeftBoundary(root.left, res);
        printLeaves(root.left, res);
        printLeaves(root.right, res);
        printRightBoundary(root.right, res);
        return res;
    }
    private void printLeftBoundary(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.left != null) {
            res.add(node.val);
            printLeftBoundary(node.left, res);
        } else if (node.right != null) {
            res.add(node.val);
            printLeftBoundary(node.right, res);
        }
    }
    private void printRightBoundary(TreeNode node, List<Integer> res) {
        if (node == null) return;
        if (node.right != null) {
            printRightBoundary(node.right, res);
            res.add(node.val);
        } else if (node.left != null) {
            printRightBoundary(node.left, res);
            res.add(node.val);
        }
    }
    private void printLeaves(TreeNode node, List<Integer> res) {
        if (node == null) return;
        printLeaves(node.left, res);
        if (node.left == null && node.right == null) res.add(node.val);
        printLeaves(node.right, res);
    }
}
