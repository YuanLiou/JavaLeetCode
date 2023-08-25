import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.ArrayUtils;
import utils.TreeNode;

public class FindLeavesOfBinaryTree {
	public static void main(String[] args) {
		var sampleClass = new FindLeavesOfBinaryTree();
		var sampleInput01 = TreeNode.arrayToBinaryTree(new Integer[]{1, 2, 3, 4, 5});
		var result01 = sampleClass.findLeaves(sampleInput01);
		ArrayUtils.printIntListMatrix(result01);

		System.out.println();
		
		var sampleInput02 = TreeNode.arrayToBinaryTree(new Integer[]{1});
		var result02 = sampleClass.findLeaves(sampleInput02);
		ArrayUtils.printIntListMatrix(result02);
	}

	public List<List<Integer>> findLeaves(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> answer = new ArrayList<>();
		treeHeight(root, answer);
		return answer;
	}

	private int treeHeight(
			TreeNode root,
			List<List<Integer>> answer
	) {
		if (root == null) {
			return -1;
		}

		int leftHeight = treeHeight(root.left, answer);
		int rightHeight = treeHeight(root.right, answer);
		int height = Math.max(leftHeight, rightHeight) + 1;

		// If the height and size is the same, create a new array
		if (answer.size() == height) {
			answer.add(new ArrayList<>());
		}
		answer.get(height).add(root.val);

		return height;
	}

	// The worst-case time complexity for this is O(n^2)
	//  It might be a skewed tree
	public List<List<Integer>> findLeavesFirstSol(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> answer = new ArrayList<>();
		TreeNode tree = root;
		while (tree != null) {
			List<Integer> leaves = new ArrayList<>();
			tree = traverse(tree, leaves);
			answer.add(leaves);
		}
		return answer;
	}

	private TreeNode traverse(
			TreeNode root,
			List<Integer> result
	) {
		if (root == null) {
			return null;
		}

		if (root.left == null && root.right == null) {
			result.add(root.val);
			return null;
		}

		root.left = traverse(root.left, result);
		root.right = traverse(root.right, result);
		return root;
	}
}
