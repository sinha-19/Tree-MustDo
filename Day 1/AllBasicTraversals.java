public class AllBasicTraversals {
    /*
     * Problem: Perform Preorder, Inorder, and Postorder using recursion
     * Time: O(N) for each, Space: O(H)
     */
    public void doAll(TreeNode root) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        traverse(root, pre, in, post);
        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }
    private void traverse(TreeNode node, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if (node == null) return;
        pre.add(node.data);
        traverse(node.left, pre, in, post);
        in.add(node.data);
        traverse(node.right, pre, in, post);
        post.add(node.data);
    }
}
