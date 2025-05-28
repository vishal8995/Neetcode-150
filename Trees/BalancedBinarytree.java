package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BalancedBinarytree {

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

    public static boolean isBalanced(TreeNode root) {

        boolean[] isBalanced = new boolean[] { true };
        heightOfTree(root, isBalanced);
        return isBalanced[0];
    }

    public static int heightOfTree(TreeNode root, boolean[] isBalanced) {

        if (root == null)
            return 0;

        int left = heightOfTree(root.left, isBalanced);
        int right = heightOfTree(root.right, isBalanced);
        if (Math.abs(left - right) > 1)
            isBalanced[0] = false;
        return 1 + Math.max(left, right);

    }

    public static void main(String[] args) {

        // Tree 1: [1,2,3,4,5]
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3));

        // Tree 2: [6,7,8,null,9,10,11]
        TreeNode root2 = new TreeNode(6,
                new TreeNode(7,
                        null,
                        new TreeNode(9)),
                new TreeNode(8,
                        new TreeNode(10),
                        new TreeNode(11)));

        System.out.println("Tree 1 (Level Order):");
        printTree(root1);
        System.out.println("\nDiameter Tree 1: " + isBalanced(root1));

        System.out.println("\nTree 2 (Level Order):");
        printTree(root2);
        System.out.println("\nDiameter Tree 2: " + isBalanced(root2));
    }

}
