package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

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

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == null || q == null)
            return null;

        if (Math.max(p.val, q.val) < root.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (Math.min(p.val, q.val) > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;

    }

    public static void main(String[] args) {
        /*
         * BST:
         * 6
         * / \
         * 2 8
         * / \ / \
         * 0 4 7 9
         * / \
         * 3 5
         */

        TreeNode root = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));

        TreeNode p = root.left; // Node 2
        TreeNode q = root.left.right.right; // Node 5

        TreeNode lca = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "null"));
    }

}
