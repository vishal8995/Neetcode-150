package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();

            for (int i = q.size(); i > 0; i++) { // Traverse the level, where all nodes at a level will be present in
                                                 // the queue at once

                TreeNode node = q.poll();
                if (node != null) {
                    level.add(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            if (level.size() > 0) // If there we no elements added to level, we don't add the list to res
                res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {

        /*
         * Tree:
         * 1
         * / \
         * 2 3
         * / \
         * 4 5
         */

        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));

        List<List<Integer>> levels = levelOrder(root);

        System.out.println("Level Order Traversal:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }

}
