import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import utils.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}

		// Breadth first search
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		List<List<Integer>> resultArray = new ArrayList<>();

		// Traverse until queue is empty
		while (!queue.isEmpty()) {
			int contentSize = queue.size();
			List<Integer> contents = new ArrayList<>();

			int currentSize = 0;
			while (currentSize < contentSize) {
				TreeNode currentNode = queue.poll();
				if (currentNode != null) {
					contents.add(currentNode.val);

					TreeNode leftNode = currentNode.left;
					if (leftNode != null) {
						queue.offer(leftNode);
					}

					TreeNode rightNode = currentNode.right;
					if (rightNode != null) {
						queue.offer(rightNode);
					}
				}

				currentSize++;
			}

			resultArray.add(contents);
		}

		return resultArray;
	}
}
