public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		int[] result = new int[n + 1];

		// cases defined in the problems
		result[0] = 1;
		result[1] = 1;

		// calculate catalan number
		// G(n) = G(i - 1) * G(n - i)
		// we already have mathN = 0 and mathN = 1 above
		for (int mathN = 2; mathN <= n; mathN++) {
			for (int mathI = 1; mathI <= mathN; mathI++) {
				// use += to calculate result from 1 to mathN
				result[mathN] += result[mathI - 1] * result[mathN - mathI];
			}
		}

		return result[n];
	}
}
