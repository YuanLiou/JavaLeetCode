import utils.TreeNode;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		TreeNode node01 = new TreeNode(2);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(2);
		node01.left = node02;
		node01.right = node03;

		var sampleClass = new ValidateBinarySearchTree();
		boolean result = sampleClass.isValidBST(node01);
		System.out.println("Result is " + result);
	}

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
}
