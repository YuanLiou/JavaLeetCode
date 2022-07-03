import utils.TreeNode;

public class DiameterOfBinaryTree {

    private static int diameter = 0;
    public static void main(String[] args) {
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int result = findNodes(root);
        return result;
    }

    private static int findNodes(TreeNode node) {
        // base case
        if (node == null) {
            return 0;
        }

        // 幫「每一個點」都找一次 Longest Path
        int leftMaxLength = findNodes(node.left);
        int rightMaxLength = findNodes(node.right);

        // 檢查目前最大長度，這是遍壢「每一個點」，所以我們可以做對比
        //  目前的直徑，以及目前的節點：leftMaxLength + rightMaxLength 有沒有比他大。
        diameter = Math.max(diameter, leftMaxLength + rightMaxLength);

        if (leftMaxLength > rightMaxLength) {
            return 1 + leftMaxLength;
        } else {
            return 1 + rightMaxLength;
        }
    }
}
