import java.util.ArrayList;
import java.util.List;

import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		var sampleClass = new BinaryTreePreorderTraversal();
		var sampleInput = TreeNode.arrayToBinaryTree(new Integer[] {1, 2, 4, 9, 7, null, 12});
		var result01 = sampleClass.preorderTraversal(sampleInput);
		ArrayUtils.printIntList(result01);
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
