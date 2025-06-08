import java.util.*;
public class AllTraversals {
    /*
     * Problem: Get preorder, inorder, and postorder in single traversal
     * Approach: Use stack and state to track stage of visit
     * Time: O(N), Space: O(N)
     */
    class Pair {
        TreeNode node;
        int state;
        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public void allTraversals(TreeNode root) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        while (!stack.isEmpty()) {
            Pair p = stack.pop();
            if (p.state == 1) {
                pre.add(p.node.data);
                p.state++;
                stack.push(p);
                if (p.node.left != null)
                    stack.push(new Pair(p.node.left, 1));
            } else if (p.state == 2) {
                in.add(p.node.data);
                p.state++;
                stack.push(p);
                if (p.node.right != null)
                    stack.push(new Pair(p.node.right, 1));
            } else {
                post.add(p.node.data);
            }
        }
        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }
}
