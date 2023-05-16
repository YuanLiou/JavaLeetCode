import utils.TreeNode;

public class CountUnivalueSubtrees {

	private int uniCounts = 0;
	public int countUnivalSubtrees(TreeNode root) {
		traverseAndCount(root);
		return uniCounts;
	}

	private boolean traverseAndCount(TreeNode root) {
		if (root == null) {
			return true;
		}

		boolean isUniLeftSubTree = traverseAndCount(root.left);
		boolean isUniRightSubTree = traverseAndCount(root.right);

		if (isUniLeftSubTree && isUniRightSubTree) {
			if (root.left == null && root.right == null) {
				uniCounts++;
				return true;
			}

			if ((root.left == null && root.right.val == root.val)
					|| (root.right == null && root.left.val == root.val)) {
				uniCounts++;
				return true;
			}

			if ((root.left != null && root.left.val == root.val)
					&& (root.right != null && root.right.val == root.val)) {
				uniCounts++;
				return true;
			}

			return false;
		}
		return false;
	}
}
