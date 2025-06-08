/*
 * Problem: Find floor in BST (largest element ≤ key).
 * Time: O(H), Space: O(1)
 */
class FloorInBST {
    public static int findFloor(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.val == key) return root.val;
            if (root.val > key) root = root.left;
            else {
                floor = root.val;
                root = root.right;
            }
        }
        return floor;
    }
}
