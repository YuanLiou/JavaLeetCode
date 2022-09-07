import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import utils.ArrayUtils;
import utils.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	public static void main(String[] args) {
		final var treeNode02 = new TreeNode(3, new TreeNode(4), new TreeNode(5));
		final var treeNode01 = new TreeNode(2);
		var sample01 = new TreeNode(1, treeNode01, treeNode02);
		TreeNode sample02 = null;

		var sampleClass = new SerializeAndDeserializeBinaryTree();
		// sample: 1,2,3,null,null,4,5
		var result01 = sampleClass.serialize(sample02);

		var ogTreeNode = sampleClass.deserialize(result01);

		System.out.println(result01);
		
		var traverseTool = new BinaryTreePreorderTraversal();
		var resultList = traverseTool.preorderTraversal(ogTreeNode);
		ArrayUtils.printIntList(resultList);
	}

	// Encodes a tree to a single string.
	private static final int NO_VALUE = -1001;
	public String serialize(TreeNode root) {
		// bfs?
		if (root == null) {
			return "";
		}

		ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
		nodes.offer(root);
		StringBuilder stringBuilder = new StringBuilder();

		var height = 0;
		while (!nodes.isEmpty()) {
			final var nodeSize = nodes.size();
			var index = 0;

			while (index < nodeSize) {
				TreeNode currentNode = nodes.poll();

				if (stringBuilder.length() > 0) {
					stringBuilder.append(",");
				}

				if (currentNode != null) {
					if (currentNode.val != NO_VALUE) {
						stringBuilder.append(currentNode.val);
					} else {
						stringBuilder.append("null");
					}
				}

				if (currentNode != null && currentNode.val != NO_VALUE) {
					if (currentNode.left != null) {
						nodes.offer(currentNode.left);
					} else {
						nodes.offer(new TreeNode(NO_VALUE));
					}

					if (currentNode.right != null) {
						nodes.offer(currentNode.right);
					} else {
						nodes.offer(new TreeNode(NO_VALUE));
					}
				}

				index++;
			}

			height++;
		}

		return stringBuilder.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		// bfs
		if (data == null || data.isEmpty()) {
			return null;
		}

		String[] values = data.split(",");
		if (values[0].equals("null")) {
			return new TreeNode();
		}

		TreeNode root = new TreeNode();
		ArrayDeque<TreeNode> elements = new ArrayDeque<>();
		String currentValue = values[0];
		root.val = Integer.parseInt(currentValue);

		elements.offer(root);

		int currentIndex = 1;
		while (currentIndex < values.length) {
			var parent = elements.poll();

			if (!values[currentIndex].equals("null")) {
				TreeNode leftNode = new TreeNode(Integer.parseInt(values[currentIndex]));
				parent.left = leftNode;
				elements.offer(leftNode);
			}

			if (!values[++currentIndex].equals("null")) {
				TreeNode rightNode = new TreeNode(Integer.parseInt(values[currentIndex]));
				parent.right = rightNode;
				elements.offer(rightNode);
			}

			currentIndex++;
		}
		
		return root;
	}
}
