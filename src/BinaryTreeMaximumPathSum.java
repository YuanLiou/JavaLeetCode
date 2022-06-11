import utils.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeMaximumPathSum {

    public static void main(String[] args) {
    }

    static int result = Integer.MIN_VALUE;
    public static int performMaxPathSum(TreeNode root) {
        // stop condition
        if (root == null) {
            return 0;
        }

        // find left, we're ignoring minus numbers
        int maxLeftTraverse = Math.max(performMaxPathSum(root.left), 0);
        // find right, we're ignoring minus numbers, too.
        int maxRightTraverse = Math.max(performMaxPathSum(root.right), 0);
        // update the result
        result = Math.max(result, maxLeftTraverse + maxRightTraverse + root.val);

        return Math.max(maxLeftTraverse, maxRightTraverse) + root.val;
    }
}
