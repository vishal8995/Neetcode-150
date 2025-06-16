package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {

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

        if (root == null)
            return new ArrayList<>(); // Empty Tree should return empty List not null

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> res = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            if (level.size() > 0)
                res.add(0, level);
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
