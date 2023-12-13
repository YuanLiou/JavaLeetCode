import utils.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {
	public static void main(String[] args) {
		var sampleClass = new MaximumDifferenceBetweenNodeAndAncestor();
		// expected = 7
		var nodeInput = new Integer[]{8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
		var result01 = sampleClass.maxAncestorDiff(TreeNode.arrayToBinaryTree(nodeInput));
		System.out.println("Result is " + result01);

		// expected = 3
		var nodeInput02 = new Integer[]{1, null, 2, null, 0, 3};
		var result02 = sampleClass.maxAncestorDiff(TreeNode.arrayToBinaryTree(nodeInput02));
		System.out.println("Result is " + result02);
	}

	public int maxAncestorDiff(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return traverseForLargestNumber(root, root.val, root.val);
	}

	private int traverseForLargestNumber(TreeNode node, int currentMax, int currentMin) {
		if (node == null) {
			return currentMax - currentMin;
		}

		currentMax = Math.max(currentMax, node.val);
		currentMin = Math.min(currentMin, node.val);

		int largestValueInLeftSubTree = traverseForLargestNumber(
				node.left,
				currentMax,
				currentMin
		);

		int largestValueInRightSubTree = traverseForLargestNumber(
				node.right,
				currentMax,
				currentMin
		);
		return Math.max(largestValueInLeftSubTree, largestValueInRightSubTree);
	}
}
