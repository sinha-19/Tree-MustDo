/*
 * Problem: Print all nodes at distance K from a target node.
 * Approach: Build parent pointers, then BFS from target to depth K.
 * Time: O(n), Space: O(n).
 */
public class NodesAtDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, null, parent);
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        seen.add(target);
        int depth = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (depth++ == K) {
                return q.stream().map(n -> n.val).collect(Collectors.toList());
            }
            while (size-- > 0) {
                TreeNode node = q.poll();
                for (TreeNode nei : Arrays.asList(node.left, node.right, parent.get(node))) {
                    if (nei != null && seen.add(nei)) {
                        q.offer(nei);
                    }
                }
            }
        }
        return Collections.emptyList();
    }
    private void dfs(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }
}
