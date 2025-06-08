/*
 * Problem: Merge two BSTs into a sorted list.
 * Approach: Inorder traversal of both trees, then merge two sorted arrays.
 * Time: O(m + n), Space: O(m + n)
 */
class MergeTwoBSTs {
    public List<Integer> merge(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        inorder(root1, l1);
        inorder(root2, l2);
        return mergeLists(l1, l2);
    }
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
    private List<Integer> mergeLists(List<Integer> l1, List<Integer> l2) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) res.add(l1.get(i++));
            else res.add(l2.get(j++));
        }
        while (i < l1.size()) res.add(l1.get(i++));
        while (j < l2.size()) res.add(l2.get(j++));
        return res;
    }
}
