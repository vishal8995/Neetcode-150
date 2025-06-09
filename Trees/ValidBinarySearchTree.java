package Trees;

public class ValidBinarySearchTree {

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

    public static boolean isValidBST(TreeNode root) {

        // Root will be a value between -infinity and infinity
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean valid(TreeNode node, long left, long right) {

        if (node == null)
            return true; // Empty BST is still valid

        // Checking if node's value is between left and right or not
        if (!(node.val > left && node.val < right))
            return false;

        // That is when checking in the left sub tree the node should be greater than
        // the left bounds but smaller the node which is its root. Similarly for right
        // node, it should be greater than it's root node but smaller that the right
        // bounds.
        return valid(node.left, left, node.val) && valid(node.right, node.val, right);

    }

    public static void main(String[] args) {
        // ✅ Valid BST:
        // 2
        // / \
        // 1 3
        //
        // Satisfies BST rules:
        // Left < Root < Right
        TreeNode validRoot = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));

        System.out.println("Valid BST? " + isValidBST(validRoot)); // Expected: true

        // ❌ Invalid BST:
        // 5
        // / \
        // 1 4
        // / \
        // 3 6
        //
        // 3 is in the right subtree of 5 but is less than 5 => violates BST
        TreeNode invalidRoot = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));

        System.out.println("Valid BST? " + isValidBST(invalidRoot)); // Expected: false
    }

}
