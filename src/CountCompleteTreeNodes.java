import com.sun.source.tree.Tree;
import utils.TreeNode;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {

    }

    public int countNodes(TreeNode root) {
        // 找左邊
        // 找右邊
        // 如果左右一樣大，就套公式 2^h - 1
        // 否則就遍歷
        if (root == null) {
            return 0;
        }

        int leftNodeCounts = calculateLeftHeight(root);
        int rightNodeCounts = calculateRightHeight(root);

        // Perfect Complete Tree
        if (leftNodeCounts == rightNodeCounts) {
            // 套公式
            return (1<<(leftNodeCounts)) - 1;
        }

        // 不是就遍歷
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int calculateLeftHeight(TreeNode node) {
        int counts = 0;
        TreeNode leftNode = node.left;
        while (leftNode != null) {
            counts++;
            leftNode = leftNode.left;
        }
        return counts;
    }

    private int calculateRightHeight(TreeNode node) {
        int counts = 0;
        TreeNode rightNode = node.right;
        while (rightNode != null) {
            counts++;
            rightNode = rightNode.right;
        }
        return counts;
    }
}
