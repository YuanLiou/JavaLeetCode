import utils.TreeNode;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		// Expected: false
		TreeNode node01 = new TreeNode(2);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(2);
		node01.left = node02;
		node01.right = node03;

		// Expected: false
		TreeNode node002 = TreeNode.arrayToBinaryTree(new Integer[]{5, 1, 4, null, null, 3, 6});
		var sampleClass = new ValidateBinarySearchTree();
		boolean result = sampleClass.isValidBST03(node01);
		System.out.println("Result is " + result);
	}

	public boolean isValidBST03(TreeNode root) {
		if (root == null) {
			return true;
		}
		// null means infinity value. (left bound is negative infinity, and right bound is infinity)
		// we use null here to prevent input value be Math_MAX or Math_MIN
		return traverse(root, null, null);
	}

	private boolean traverse(TreeNode node, Integer leftBound, Integer rightBound) {
		if (node == null) {
			return true;
		}

		if ((leftBound != null && node.val <= leftBound) ||
			(rightBound != null && node.val >= rightBound)) {
			return false;
		}

		// Find left and right subtree
		return traverse(node.left, leftBound, node.val) &&
				traverse(node.right, node.val, rightBound);
	}


	//region Second Try
	private boolean isValidBst02 = true;
	private Integer previousNumber = null;
	public boolean isValidBST02(TreeNode root) {
		if (root == null) {
			return true;
		}

		traverseTree02(root);
		return isValidBst02;
	}
	private void traverseTree02(TreeNode node) {
		if (node == null) {
			return;
		}

		// 中序遍壢(l - h - r), 如果是 BST, 在中序遍壢之中，數字會由小排列到大
		traverseTree02(node.left);

		int current = node.val;
		if (previousNumber == null) {
			previousNumber = current;
		} else {
			if (current > previousNumber) {
				previousNumber = current;
			} else {
				isValidBst02 = false;
			}
		}
		traverseTree02(node.right);
	}
	//endregion

	//region First Try
	private boolean isValidBst = true;
	private Integer savedInteger = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return false;
		}

		// in order traverse
		traverseTree(root);
		return isValidBst;
    }
	private void traverseTree(TreeNode root) {
		// base case
		if (root == null) {
			return;
		}

		// in order: l-n-r
		traverseTree(root.left);
		int currentInteger = root.val;
		if (savedInteger == null || currentInteger > savedInteger) {
			savedInteger = currentInteger;
		} else {
			isValidBst = false;
		}
		traverseTree(root.right);
	}
	//endregion
}
