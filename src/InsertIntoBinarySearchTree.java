import utils.TreeNode;

public class InsertIntoBinarySearchTree {
	public static void main(String[] args) {
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		// base case
		if (root == null) {
			return new TreeNode(val);
		}

		// 1.) If val is smaller then root.val, find left
		if (root.val > val) {
			TreeNode node = insertIntoBST(root.left, val);
			if (node != root) {
				// We're in leaf
				root.left = node;
			}
		}

		// 2.) If val is larger then root.val, find right
		if (root.val < val) {
			TreeNode node = insertIntoBST(root.right, val);
			if (node != root) {
				// We're in leaf
				root.right = node;
			}
		}

		return root;
    }
}
