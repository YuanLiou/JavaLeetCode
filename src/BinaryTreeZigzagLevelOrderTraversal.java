import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.ArrayUtils;
import utils.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		var sampleClass = new BinaryTreeZigzagLevelOrderTraversal();
		// expected: [[3],[20,9],[15,7]]
		var array01 = new Integer[]{3, 9, 20, null, null, 15, 7};
		var sampleInput = TreeNode.arrayToBinaryTree(array01);
		var result01 = sampleClass.zigzagLevelOrder(sampleInput);
		for (List<Integer> list : result01) {
			ArrayUtils.printIntList(list);
			System.out.println();
		}

		// expected: [[[0],[4,2],[1,3,-1],[8,6,1,5]]]
		var array02 = new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8};
		var sampleInput02 = TreeNode.arrayToBinaryTree(array02);
		var result02 = sampleClass.zigzagLevelOrder(sampleInput02);
		for (List<Integer> list : result02) {
			ArrayUtils.printIntList(list);
			System.out.println();
		}

	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int round = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> currentResult = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					continue;
				}

				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}

				if (round % 2 == 0) {
					currentResult.add(node.val);
				} else {
					// Add the new value to the end of a ArrayList
					currentResult.addFirst(node.val);
				}
			}
			result.add(currentResult);
			round++;
		}

		return result;
	}
}
