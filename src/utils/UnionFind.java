package utils;

public class UnionFind {
	int[] roots;
	int[] ranks;

	UnionFind(int size) {
		roots = new int[size];
		ranks = new int[size];
		for (int i = 0; i < size; i++) {
			roots[i] = i;
			ranks[i] = 1;
		}
	}

	private int find(int x) {
		if (x == roots[x]) {
			return x;
		}

		roots[x] = find(roots[x]);
		return roots[x];
	}

	// union by rank
	public void union(int x, int y) {
		var rootX = find(x);
		var rootY = find(y);
		if (rootX == rootY) {
			return;
		}

		if (ranks[rootX] > ranks[rootY]) {
			roots[rootY] = roots[rootX];
		} else if (ranks[rootX] < ranks[rootY]) {
			roots[rootX] = roots[rootY];
		} else {
			roots[rootY] = roots[rootX];
			ranks[rootX] += 1;
		}
	}

	public boolean isConnected(int x, int y) {
		return find(x) == find(y);
	}
}
