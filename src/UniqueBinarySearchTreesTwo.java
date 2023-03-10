import utils.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UniqueBinarySearchTreesTwo {

	public static void main(String[] args) {
		var sampleClass01 = new UniqueBinarySearchTrees();
		var sampleClass02 = new UniqueBinarySearchTreesTwo();
		// expected:
		var result = sampleClass02.numTrees(2);
		System.out.println("Result is " + result);
	}

	public int numTrees(int n) {
		int[] result = new int[n + 1];

		// base case which the question give us
		result[0] = 1;
		result[1] = 1;

		// Calculate catalan numbers
		// We have already calculate mathN = 0 and mathN = 1
		for (int mathN = 2; mathN <= n; mathN++) {
			for (int mathI = 1; mathI <= mathN; mathI++) {
				// G(n) += G(i - 1) * n(n - i)
				int current = result[mathI - 1] * result[mathN - mathI];
				System.out.println("current is " + current);
				result[mathN] += current;
			}
		}
		return result[n];
	}

	public List<TreeNode> generateTrees(int n) {
		if (n == 0) {
			return Collections.emptyList();
		}
		// The question is start at 1 to n
		return generateTreeNodes(1, n);
	}

	private List<TreeNode> generateTreeNodes(int start, int end) {
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
