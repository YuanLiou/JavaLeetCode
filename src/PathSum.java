import utils.TreeNode;

public class PathSum {
    public static void main(String[] args) {
    }

    public boolean hasPathSumTopBottom(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return traverseTopDown(root, targetSum, root.val);
    }

    private boolean traverseTopDown(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        // encounter a leaf
        if (root.left == null && root.right == null) {
            if (currentSum == targetSum) {
                return true;
            } else {
                return false;
            }
        }

        var isLeftPathHasTarget = false;
        if (root.left != null) {
            isLeftPathHasTarget = traverseTopDown(root.left, targetSum, currentSum + root.left.val);
        }

        var isRightPathHasTarget = false;
        if (root.right != null) {
            isRightPathHasTarget = traverseTopDown(root.right, targetSum, currentSum + root.right.val);
        }

        return isLeftPathHasTarget || isRightPathHasTarget;
    }
}
