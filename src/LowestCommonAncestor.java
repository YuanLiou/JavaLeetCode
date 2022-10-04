import utils.TreeNode;

public class LowestCommonAncestor {
	public static void main(String[] args) {
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// Base case 00
		if (root == null) {
			return null;
		}
		
		// Base case 01: My children is p and q
		if ((root.left != null && root.right != null) &&
				(root.left == p && root.right == q) ||
				(root.right == p && root.left == q)) {
			return root;
		}

		// Base case 02: My Self is p or q
		if (root == p || root == q) {
			return root;
		}

		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
		if (leftNode != null && rightNode != null) {
			return root;
		}

		if (leftNode != null) {
			return leftNode;
		}

		if (rightNode != null) {
			return rightNode;
		}
		return null;
	}
}
