import utils.TreeNode;

import java.util.*;

public class DeleteNodesAndReturnForest {
	public static void main(String[] args) {

	}

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		Set<Integer> toDelete = new HashSet<>();
		for (int i = 0; i < to_delete.length; i++) {
			toDelete.add(to_delete[i]);
		}

		List<TreeNode> remaining = new ArrayList<>();
		traverse(root, toDelete, remaining);

		// check if we need to add root into our remaining.
		if (!toDelete.contains(root.val)) {
			remaining.add(root);
		}

		return remaining;
	}

	// DFS
	private TreeNode traverse(TreeNode root, Set<Integer> toDelete, List<TreeNode> remaining) {
		// base case
		if (root == null) {
			return null;
		}

		// post order traversal like...
		root.left = traverse(root.left, toDelete, remaining);
		root.right = traverse(root.right, toDelete, remaining);

		var selfValue = root.val;
		if (toDelete.contains(selfValue)) {
			if (root.left != null) {
				remaining.add(root.left);
			}

			if (root.right != null) {
				remaining.add(root.right);
			}
			return null;
		}
		return root;
	}
}
