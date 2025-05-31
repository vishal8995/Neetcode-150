package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {

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

    // Vishal
    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    if (i == qSize - 1)
                        res.add(node.val);

                    if (node.left != null)
                        q.add(node.left);
                    if (node.right != null)
                        q.add(node.right);
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {

        // Tree 1: [1,2,3,null,5,null,4]
        TreeNode root1 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4)));

        // Tree 2: [10,6,15,4,null,null,20,25]
        TreeNode root2 = new TreeNode(10,
                new TreeNode(6, new TreeNode(4, new TreeNode(25), null), null),
                new TreeNode(15, null, new TreeNode(20)));

        List<Integer> result1 = rightSideView(root1);
        List<Integer> result2 = rightSideView(root2);

        System.out.println("Right side view (Tree 1): " + result1);
        System.out.println("Right side view (Tree 2): " + result2);
    }

}
