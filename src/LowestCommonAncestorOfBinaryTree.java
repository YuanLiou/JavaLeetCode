import utils.TreeNode;

public class LowestCommonAncestorOfBinaryTree {
	public static void main(String[] args) {
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		// n-l-r
		// 1. Is nodes coming from my left tree of right tree is P or Q?
		TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

		if (leftNode != null && rightNode != null &&
				(leftNode.val == p.val && rightNode.val == q.val || leftNode.val == q.val && rightNode.val == p.val)) {
			return root;
		}

		if (leftNode != null) {
			if (root.val == p.val || root.val == q.val) {
				// This root node has a value of p or q, and may also be a LCA
				return root;
			}

			return leftNode;
		}

		if (rightNode != null) {
			if (root.val == p.val || root.val == q.val) {
				// This root node has a value of p or q, and may also be a LCA
				return root;
			}

			return rightNode;
		}

		// 2. Is my self P or Q?
		if (root.val == p.val || root.val == q.val) {
			return root;
		}

		return null;
	}
}
