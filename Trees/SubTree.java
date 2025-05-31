package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SubTree {

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

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null)
            return false;

        if (subRoot == null)
            return true;

        if (isSameTree(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isSameTree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot == null)
            return true;

        if (root != null && subRoot != null && root.val == subRoot.val)
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right,
                    subRoot.right);
        else
            return false;

        // if (root == null || subRoot == null || root.val != subRoot.val)
        // return false;

        // return isSameTree(root.left, subRoot.left) && isSameTree(root.right,
        // subRoot.right);
    }

    public static void main(String[] args) {
        // Tree 1 (root): [3, 4, 5, 1, 2]
        TreeNode root = new TreeNode(3,
                new TreeNode(4,
                        new TreeNode(1),
                        new TreeNode(2)),
                new TreeNode(5));

        // Tree 2 (subRoot): [4, 1, 2]
        TreeNode subRoot = new TreeNode(4,
                new TreeNode(1),
                new TreeNode(2));

        boolean result = isSubtree(root, subRoot);
        System.out.println("Is subRoot a subtree of root? " + result);
    }
}
