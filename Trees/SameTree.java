package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {

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

    // Neetcode
    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p != null && q != null && p.val == q.val) { // If p is not null, q is not null, and both have same values
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else
            return false;

    }

    // Simpler to understand
    public static boolean isSameTree2(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;

        if (p == null || q == null || p.val != q.val) // If p is null, or q is null or if both are not null but have
                                                      // different values
            return false;

        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);

    }

    public static void main(String[] args) {

        // Identical Trees
        TreeNode p1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        TreeNode q1 = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3));

        // Different Trees
        TreeNode p2 = new TreeNode(1,
                new TreeNode(2),
                null);

        TreeNode q2 = new TreeNode(1,
                null,
                new TreeNode(2));

        System.out.println("First Pair (Should be true): " + isSameTree(p1, q1));
        System.out.println("Second Pair (Should be false): " + isSameTree(p2, q2));
    }

}
