package Trees;

public class CountGoodNodesBinaryTree {

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

    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public static int dfs(TreeNode node, int maxVal) {
        if (node == null)
            return 0;

        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);

        return res;
    }

    public static void main(String[] args) {

        // 🌳 Tree 1:
        // 3
        // / \
        // 1 4
        // / \
        // 3 5
        //
        // Good nodes: 3, 4, 5 (and root 3) => Total: 4
        TreeNode root1 = new TreeNode(3,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(5)));

        System.out.println("Good nodes in Tree 1: " + goodNodes(root1)); // Expected: 4

        // 🌳 Tree 2:
        // 2
        // / \
        // 2 2
        // /
        // 1
        //
        // Good nodes: all 2s (root, left, right) => Total: 3
        TreeNode root2 = new TreeNode(2,
                new TreeNode(2, new TreeNode(1), null),
                new TreeNode(2));

        System.out.println("Good nodes in Tree 2: " + goodNodes(root2)); // Expected: 3
    }
}