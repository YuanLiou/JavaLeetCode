import utils.TreeNode;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(3);

        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node3 = new TreeNode(2, null, node4);

        TreeNode node = new TreeNode(1, node2, node3);

        SymmetricTree symmetricTree = new SymmetricTree();
        var result01 = symmetricTree.isSymmetric(node);

        System.out.println("Result 01 is " + result01);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        return traverseChildren(root.left, root.right);
    }

    private boolean traverseChildren(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null && rightRoot == null) {
            return true;
        }

        if (leftRoot == null || rightRoot == null) {
            return false;
        }

        if (leftRoot.val != rightRoot.val) {
            return false;
        }

        boolean isLeftChildrenSymmetric = traverseChildren(leftRoot.left, rightRoot.right);
        boolean isRightChildrenSymmetric = traverseChildren(leftRoot.right, rightRoot.left);
        return isLeftChildrenSymmetric && isRightChildrenSymmetric;
    }
}
