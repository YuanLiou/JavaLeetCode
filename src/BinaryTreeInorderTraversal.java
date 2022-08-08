import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraverse(root, result);
        return result;
    }

    private void inorderTraverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // find very left --> pop current node --> find right --> (Loop)
        inorderTraverse(root.left, result);
        result.add(root.val);
        inorderTraverse(root.right, result);
    }
}
