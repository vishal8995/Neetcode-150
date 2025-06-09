package Trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestNodeInBST {

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

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        dfs(root, inOrder);

        return inOrder.get(k - 1);
    }

    public static void dfs(TreeNode node, List<Integer> arr) {
        if (node == null)
            return;

        dfs(node.left, arr);
        arr.add(node.val);
        dfs(node.right, arr);
    }

    public static void main(String[] args) {
        // 🌳 Tree:
        // 5
        // / \
        // 3 6
        // / \
        // 2 4
        // /
        // 1
        //
        // In-order traversal: [1, 2, 3, 4, 5, 6]

        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2, new TreeNode(1), null),
                        new TreeNode(4)),
                new TreeNode(6));

        System.out.println("k = 1 → " + kthSmallest(root, 1)); // Expected: 1
        System.out.println("k = 3 → " + kthSmallest(root, 3)); // Expected: 3
        System.out.println("k = 6 → " + kthSmallest(root, 6)); // Expected: 6
    }

}