import utils.TreeNode;

public class SearchInBinarySearchTree {
	public static void main(String[] args) {
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
