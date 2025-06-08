/*
 * Problem: Find the ceil of a given value in BST.
 * Ceil = smallest element >= target.
 * Time: O(H), Space: O(1) — H is height of BST.
 */
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) { val = x; }
}
public class CeilInBST {
    public static int findCeil(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key) return key;
            if (root.val < key) root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
}
