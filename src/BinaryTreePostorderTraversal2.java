import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreePostorderTraversal2 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = null;
        treeNode.right = new TreeNode(2, new TreeNode(3), null);

        // Expected: 3, 2, 1
        var result = postorderTraversal(treeNode);
        ArrayUtils.printIntList(result);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            // postorder: l r n
            // find very left --> find [very] right --> pop current node --> (Loop)
            if (currentNode != null) {
                // postorder: [l] r n
                // Keep exploring the left side of children
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                // The section handles we reach the right side
                // of a child
                // keep in mind, current node is point to null, So we needs
                // to get the top item of the stack
                TreeNode topStackItemRightChild = stack.peek().right;
                if (topStackItemRightChild != null) {
                    // postorder: l [r] n
                    // We have right side to explore!
                    currentNode = topStackItemRightChild;
                } else {
                    // postorder: l r [n]
                    // left side and right side both are null.
                    // visit itself.

                    TreeNode temp = stack.pop();
                    result.add(temp.val);

                    // Quick check if the current node is the child of
                    // the one who is on the top of the stack.
                    // Which means we've reached all its node, it can also be popped out.
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                }
            }
        }

        return result;
    }
}
