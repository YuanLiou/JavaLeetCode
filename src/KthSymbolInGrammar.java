public class KthSymbolInGrammar {
	public int kthGrammar(int n, int k) {
		// base case, index is start from 1 according to the question
		if (n == 1) {
			return 0;
		}

		boolean isKOdd = k % 2 == 0;
		if (isKOdd) {
			int parent = kthGrammar(n - 1, k / 2);
			if (parent == 0) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return kthGrammar(n - 1, k / 2 + 1);
		}
	}
}
