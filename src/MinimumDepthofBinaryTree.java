import utils.TreeNode;

public class MinimumDepthofBinaryTree {
	public static void main(String[] args) {
		var sampleClass = new MinimumDepthofBinaryTree();
		// expected: 2
//		Integer[] sampleInput = new Integer[]{3, 9, 20, null, null, 15, 7};
//		TreeNode node = TreeNode.arrayToBinaryTree(sampleInput);

		// expected: 5
		Integer[] sampleInput02 = new Integer[]{2, null, 3, null, 4, null, 5, null, 6};
		TreeNode node02 = TreeNode.arrayToBinaryTree(sampleInput02);

//		int result = sampleClass.minDepth(node);
//		System.out.println("Result is " + result);

		int result02 = sampleClass.minDepth(node02);
		System.out.println("Result02 is " + result02);
	}

	int depth = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		traverseDepth(root, 1);
		return depth;
	}

	private void traverseDepth(TreeNode root, int currentDepth) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			depth = Math.min(depth, currentDepth);
		}

		traverseDepth(root.left, currentDepth + 1);
		traverseDepth(root.right, currentDepth + 1);
	}
}
