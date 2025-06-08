/*
 * Problem: Construct binary tree from postorder and inorder arrays.
 * Approach: Last in postorder is root; split inorder, recursively build subtrees.
 * Time: O(n), Space: O(n).
 */
public class BuildTreePostIn {
    static class TreeNode { int val; TreeNode left, right; TreeNode(int v) { val = v; } }
    private int postIdx;
    private Map<Integer, Integer> idxMap = new HashMap<>();
    public TreeNode build(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++)
            idxMap.put(inorder[i], i);
        return buildSub(0, inorder.length - 1, postorder);
    }
    private TreeNode buildSub(int l, int r, int[] post) {
        if (l > r) return null;
        int rootVal = post[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int idx = idxMap.get(rootVal);
        root.right = buildSub(idx + 1, r, post);
        root.left = buildSub(l, idx - 1, post);
        return root;
    }
}
