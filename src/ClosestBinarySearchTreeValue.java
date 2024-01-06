import utils.TreeNode;

public class ClosestBinarySearchTreeValue {

	public static void main(String[] args) {
		var sampleClass = new ClosestBinarySearchTreeValue();
		// example 01, expected 3
		var input01 = TreeNode.arrayToBinaryTree(new Integer[]{4, 2, 5, 1, 3});
		var target01 = 3.5;
		var result01 = sampleClass.closestValue(input01, target01);
		System.out.println("Result 01 is " + result01);
	}

	private double distances = Double.MAX_VALUE;
	private int result = -1;
	public int closestValue(TreeNode root, double target) {
		traverse(root, target);
		return result;
	}
	private void traverse(TreeNode root, double target) {
		if (root == null) {
			return;
		}

		if (result == -1) {
			result = root.val;
		}

		double current = Math.abs(root.val - target);
		if (current < distances) {
			distances = current;
			result = root.val;
		} else if (current == distances && root.val < result) {
			result = root.val;
		}

		if (target < root.val) {
			traverse(root.left, target);
		} else if (target > root.val) {
			traverse(root.right, target);
		}
	}
}
