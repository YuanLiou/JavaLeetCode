import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import utils.TreeNode;

public class BinaryTreePreorderTraversal2 {
    public static void main(String[] args) {
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            result.add(currentNode.val);

            // Add children with Right first then Left.
            // That is because Stack is a LIFO(FILO) structure.
            // When popping the top of a child, we should get left child first.

            TreeNode rightChild = currentNode.right;
            if (rightChild != null) {
                nodeStack.push(rightChild);
            }

            TreeNode leftChild = currentNode.left;
            if (leftChild != null) {
                nodeStack.push(leftChild);
            }
        }
        return result;
    }
}