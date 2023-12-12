package utils;

import org.jetbrains.annotations.Nullable;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public static void main(String[] args) {
		Integer[] inputArray = new Integer[]{1, 2, 4, 6, null, 2};
		TreeNode root = arrayToBinaryTree(inputArray);
		printTree(root);
	}

	@Nullable
	public static TreeNode arrayToBinaryTree(Integer[] inputArray) {
		if (inputArray == null || inputArray.length == 0) {
			return null;
		}

		// generate root node
		TreeNode treeNode = new TreeNode(inputArray[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(treeNode);

		int index = 1;
		while (!queue.isEmpty() && index < inputArray.length) {
			TreeNode currentNode = queue.poll();

			// 處理左子樹
			if (inputArray[index] != null) {
				currentNode.left = new TreeNode(inputArray[index]);
				queue.offer(currentNode.left);
			}
			index++;

			// 處理右子樹
			if (index < inputArray.length && inputArray[index] != null) {
				currentNode.right = new TreeNode(inputArray[index]);
				queue.offer(currentNode.right);
			}
			index++;
		}
		return treeNode;
	}

	@Nullable
	public static TreeNode listToBinaryTree(List<Integer> inputList) {
		if (inputList == null || inputList.isEmpty()) {
			return null;
		}
		Integer[] inputArray = new Integer[inputList.size()];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = inputList.get(i);
		}
		return arrayToBinaryTree(inputArray);
	}

	public static void printTree(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.println(node.val + " ");
		printTree(node.left);
		printTree(node.right);
	}
}