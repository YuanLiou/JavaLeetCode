import utils.TreeNode;

public class BalancedBinaryTree {
	public static void main(String[] args) {
	}

	public boolean isBalanced(TreeNode root) {
		return calculateTreeHeight(root) > -2;
	}

	private int calculateTreeHeight(TreeNode root) {
		// Base case
		if (root == null) {
			return -1;
		}

		// Find left subtree then right subtree's height
		int leftHeight = calculateTreeHeight(root.left);
		int rightHeight = calculateTreeHeight(root.right);

		// ignore false scenario
		if (leftHeight == -2 || rightHeight == -2) {
			return -2;
		}

		// Math.abs(leftHeight - rightHeight) <= 1
		boolean isBalanced = Math.abs(leftHeight - rightHeight) <= 1;
		if (isBalanced) {
			// Return the height of current tree
			// Math.max(leftHeight, rightHeight) + 1
			return Math.max(leftHeight, rightHeight) + 1;
		}

		// if not return false scenario
		return -2;
	}
}
