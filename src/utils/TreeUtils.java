package utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {
	public static List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return Collections.emptyList();
		}
		// The question is start at 1 to n
		return generateTreeNodes(1, n);
	}

	private static List<TreeNode> generateTreeNodes(int start, int end) {
		LinkedList<TreeNode> result = new LinkedList<>();
		if (end < start) {
			result.add(null);
			return result;
		}

		for (int i = start; i <= end; i++) {
			// dfs to the left
			var leftSubTree = generateTreeNodes(start, i - 1);
			// dfs to the right
			var rightSubTree = generateTreeNodes(i + 1, end);

			for (TreeNode leftNodes : leftSubTree) {
				for (TreeNode rightNodes : rightSubTree) {
					TreeNode node = new TreeNode(i);
					node.left = leftNodes;
					node.right = rightNodes;
					result.add(node);
				}
			}
		}
		return result;
	}
}
