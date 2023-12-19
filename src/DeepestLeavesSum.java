import java.util.LinkedList;
import java.util.Queue;
import utils.TreeNode;

public class DeepestLeavesSum {
	public static void main(String[] args) {
		var sampleClass = new DeepestLeavesSum();

		var tree01 = new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8};
		// expected 15
		var sample01 = TreeNode.arrayToBinaryTree(tree01);
		var result01 = sampleClass.deepestLeavesSum(sample01);
		System.out.println("Result 01 is " + result01);

		var tree02 = new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
		// expected 19
		var sample02 = TreeNode.arrayToBinaryTree(tree02);
		var result02 = sampleClass.deepestLeavesSum(sample02);
		System.out.println("Result 02 is " + result02);
	}

	public int deepestLeavesSum(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int result = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			int currentSum = 0;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null && node.left != null) {
					queue.offer(node.left);
				}

				if (node != null && node.right != null) {
					queue.offer(node.right);
				}

				if (node != null) {
					currentSum += node.val;
				}

				// if this run is the final run of counting node in a layer
				if (i == size - 1) {
					result = currentSum;
				}
			}
		}
		return result;
	}
}
