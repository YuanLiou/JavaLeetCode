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
}
