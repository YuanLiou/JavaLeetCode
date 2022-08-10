import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.TreeNode;

public class BinaryTreePostorderTraversal {

    public static void main(String[] args) {
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        // postorder: l -> r -> n
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        // base case
        if (root == null) {
            return;
        }

        // find very left --> find very right --> pop current node --> (Loop)
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        var currentValue = root.val;
        result.add(currentValue);
    }
}
