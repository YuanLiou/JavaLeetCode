import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreeInorderTraversal2 {

	public static void main(String[] args) {
		var sampleClass = new BinaryTreeInorderTraversal2();
		var sampleInput = TreeNode.arrayToBinaryTree(new Integer[]{1, 2, 4, 9, 7, null, 12});
		var result01 = sampleClass.inorderTraversal(sampleInput);
		ArrayUtils.printIntList(result01);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		// inorder: l n r
		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		// find very left --> pop current node --> find right --> (Loop)
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			TreeNode itself = stack.pop();
			result.add(itself.val);

			current = itself.right;
		}

		return result;
	}
}
