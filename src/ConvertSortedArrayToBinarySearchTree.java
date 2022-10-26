import utils.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		var sampleClass = new ConvertSortedArrayToBinarySearchTree();
		var sample01 = new int[]{-10, -3, 0, 5, 9};
		var sample02 = new int[]{1, 3};
		var result = sampleClass.sortedArrayToBST(sample02);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}

		return constructTree(nums, 0, nums.length - 1);
	}

	private TreeNode constructTree(int[] nums, int start, int end) {
		// Base Case
		if (start > end) {
			return null;
		}

		// Binary Search
		// 1.) Find the center one as the new root
		//  or mid = low + ((high - low) / 2)
		int midpoint = (start + end) >>> 1;
		TreeNode treeNode = new TreeNode(nums[midpoint]);
		// 2.) Construct Left and Right subtrees
		treeNode.left = constructTree(nums, start, midpoint - 1);
		treeNode.right = constructTree(nums, midpoint + 1, end);
		return treeNode;
	}
}
