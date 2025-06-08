/*
 * Problem: Minimum time to burn tree from a target node.
 * Approach: BFS using parent pointers, track time levels.
 * Time: O(n), Space: O(n).
 */
public class MinTimeToBurn {
    public int burnTime(TreeNode root, TreeNode target) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, null, parent);
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        seen.add(target);
        int time = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            boolean burnt = false;
            while (sz-- > 0) {
                TreeNode node = q.poll();
                for (TreeNode nei : Arrays.asList(node.left, node.right, parent.get(node))) {
                    if (nei != null && seen.add(nei)) {
                        burnt = true;
                        q.offer(nei);
                    }
                }
            }
            if (burnt) time++;
        }
        return time;
    }
    private void dfs(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }
}
