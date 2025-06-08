public class TreeIntroAndDriver {
    public static void main(String[] args) {
        /*
         * Problem: Introduction to Trees + Sample Tree Creation
         * Approach: Manually create tree nodes
         */
        TreeNode root = new TreeNode(1);              // Level 0
        root.left = new TreeNode(2);                  // Level 1
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);             // Level 2
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Sample tree built successfully.");
    }
}
