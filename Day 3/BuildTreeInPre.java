/*
 * Problem: Construct binary tree from inorder and preorder arrays.
 * Approach: Recursion with index mapping, splitting arrays. Time O(n), Space O(n).
 */
public class BuildTreeInPre {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    private int preIdx;
    private Map<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode build(int[] preorder, int[] inorder) {
        preIdx = 0;
        for (int i = 0; i < inorder.length; i++)
            idxMap.put(inorder[i], i);
        return buildSub(0, inorder.length - 1, preorder);
    }
    private TreeNode buildSub(int left, int right, int[] pre) {
        if (left > right) return null;
        int rootVal = pre[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int idx = idxMap.get(rootVal);
        root.left = buildSub(left, idx - 1, pre);
        root.right = buildSub(idx + 1, right, pre);
        return root;
    }
}
