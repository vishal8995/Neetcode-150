package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode curr = queue.remove();
            System.out.print(curr.val + " ");

            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);
        }
    }

    // Recursive DFS: O(n) both space and time
    public static int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;

    }

    // BFS / Level Order Traversal: O(n) for both
    public static int maxDepthBFS(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null)
            q.add(root);

        int level = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode curr = q.remove();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            level++; // Incrementing the level, after removing the node(s) and we also start from 0
        }

        return level;
    }

    public static void main(String[] args) {

        // Tree 1: [1,2,3,null,null,4]
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4), null));

        // Tree 2: [5,6,7,8,null,9,10]
        TreeNode root2 = new TreeNode(5,
                new TreeNode(6,
                        new TreeNode(8,
                                new TreeNode(11), null),
                        null),
                new TreeNode(7,
                        new TreeNode(9), new TreeNode(10)));

        System.out.println("Tree 1 (Level Order):");
        printTree(root1);
        System.out.println("\nMax Depth Tree 1: " + maxDepth(root1));

        System.out.println("\nTree 2 (Level Order):");
        printTree(root2);
        System.out.println("\nMax Depth Tree 2: " + maxDepth(root2));
    }
}
