import utils.TreeNode;

public class DeleteNodeFromBST {
	public static void main(String[] args) {
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		// base case
		if (root == null) {
			return null;
		}

		// Find the target and remove it
		if (root.val < key) {
			// 1.) Key is larger than the root.value, find right
			root.right = deleteNode(root.right, key);
		} else if (root.val > key) {
			// 2.) Key is smaller than the root.value, find left
			root.left = deleteNode(root.left, key);
		} else {
			// Condition A: There is no child.
			if (root.left == null && root.right == null) {
				// Remove itself
				return null;
			}

			// Condition B: There is one child.
			if (root.left == null || root.right == null) {
				return root.left != null ? root.left : root.right;
			}

			// Condition C: There are two child nodes.
			// 3.) find the target key
			//  Two-way to solve, swap current point
			//    - to the minimum value of the right tree  <== here we choose this
			//    - to the maximum value of the left tree
			// Because we choose swapping the right tree, all the operations below
			// would happen in root.right.

			// 4.) Find the very X point
			TreeNode rightMinimumNode = findMinimumValue(root.right);

			// 5.) Remove the X point we found at step 4
			root.right = deleteNode(root.right, rightMinimumNode.val);
			// 6.) Swap the value of current node
			root.val = rightMinimumNode.val;
		}

		return root;
	}

	private TreeNode findMinimumValue(TreeNode treeNode) {
		// 1. ) Find the very left value
		TreeNode current = treeNode;
		while (current.left != null) {
			current = current.left;
		}
		return current;
	}
}
