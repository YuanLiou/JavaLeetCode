import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		var sampleClass = new BinaryTreePostorderTraversal();
		var sampleInput = TreeNode.arrayToBinaryTree(new Integer[] {1, 2, 4, 9, 7, null, 12});
		var result01 = sampleClass.postorderTraversal(sampleInput);
		ArrayUtils.printIntList(result01);
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
