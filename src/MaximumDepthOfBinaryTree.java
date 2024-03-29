import utils.TreeNode;

public class MaximumDepthOfBinaryTree {
	public static void main(String[] args) {
	}

	// Third Practice

	private int depth = 0;

	public int maxDepth(TreeNode root) {
		traverse02(root, 0);
		return depth;
	}

	private void traverse02(TreeNode root, int currentDepth) {
		if (root == null) {
			return;
		}

		currentDepth = currentDepth + 1;
		depth = Math.max(currentDepth, depth);
		traverse02(root.left, currentDepth);
		traverse02(root.right, currentDepth);
	}

	public int maxDepthBottomUp(TreeNode root) {
		// bottom-up solution
		if (root == null) {
			return 0;
		}

		int leftNodeCounts = maxDepthBottomUp(root.left);
		int rightNodeCounts = maxDepthBottomUp(root.right);
		return Math.max(leftNodeCounts, rightNodeCounts) + 1;
	}

	int depthCount = 0;

	public int maxDepthTopDown(TreeNode root) {
		// top-down solution
		traverse(root, 1);
		return depthCount;
	}

	private void traverse(TreeNode root, int depthCounts) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			// Compare which counts of the maximum depth is the deepest one.
			this.depthCount = Math.max(this.depthCount, depthCounts);
		}

		traverse(root.left, depthCounts + 1);
		traverse(root.right, depthCounts + 1);
	}
}
