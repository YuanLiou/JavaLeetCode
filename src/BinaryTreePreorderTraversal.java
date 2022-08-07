import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.TreeNode;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }

    private void traverse(TreeNode root, List<Integer> result) {
        // Base case
        if (root == null) {
            return;
        }

        int value = root.val;
        result.add(value);

        traverse(root.left, result); // find left
        traverse(root.right, result); // find right
    }
}
