import utils.TreeNode;

public class SearchInBinarySearchTree {
	public static void main(String[] args) {
	}

	// Second practice, this will run longer than the original version
	public TreeNode searchBST02(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		
		if (root.val == val) {
			return root;
		}

		// Node - Left - Right
		var leftResult = searchBST02(root.left, val);
		if (leftResult != null) {
			return leftResult;
		}

		var rightResult = searchBST02(root.right, val);
		if (rightResult != null) {
			return rightResult;
		}
		return null;
	}

	public TreeNode searchBST(TreeNode root, int val) {
		// base case 01
		if (root == null) {
			return null;
		}

		// 2.) if val is smaller then root.val
		if (root.val > val) {
			// Find left
			return searchBST(root.left, val);
		}

		// 3.) if val is larger then root.val
		if (root.val < val) {
			// Find right
			return searchBST(root.right, val);
		}

		// base cass 02
		// 1.) if val is the same value as val
		return root;
	}
}
