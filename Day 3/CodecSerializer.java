/*
 * Problem: Serialize and Deserialize binary tree.
 * Approach: Preorder traversal with "null" markers; reverse operation uses queue.
 * Time: O(n), Space: O(n).
 */
public class CodecSerializer {
    private static final String SEP = ",";
    private static final String NULL = "#";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        build(root, sb);
        return sb.toString();
    }
    private void build(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        build(node.left, sb);
        build(node.right, sb);
    }
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return rebuild(queue);
    }
    private TreeNode rebuild(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals(NULL)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(s));
        node.left = rebuild(queue);
        node.right = rebuild(queue);
        return node;
    }
}
