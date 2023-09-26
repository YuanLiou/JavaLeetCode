import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreePreorderTraversal2 {

	public static void main(String[] args) {
		var sampleClass = new BinaryTreePreorderTraversal2();
		var sampleInput = TreeNode.arrayToBinaryTree(new Integer[]{1, 2, 4, 9, 7, null, 12});
		var result01 = sampleClass.preorderTraversal(sampleInput);
		ArrayUtils.printIntList(result01);
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