public class GraphValidTreeUnionFind {
	public static void main(String[] args) {
		var sampleClass = new GraphValidTreeUnionFind();
		var sample01 = new int[][] {
				{0, 1},
				{0, 2},
				{0, 3},
				{1, 4}
		};
		var sample01N = 5;
		// Expected: true
		var result = sampleClass.validTree(sample01N, sample01);
		System.out.println("Result is " + result);

		var sample02 = new int[][] {
				{0, 1},
				{1, 2},
				{2, 3},
				{1, 3},
				{1, 4}
		};
		var sample02N = 5;
		// Expected: false
		var result02 = sampleClass.validTree(sample02N, sample02);
		System.out.println("Result02 is " + result02);
	}

	private class UnionFind {
		int[] roots;
		int[] ranks;

		public UnionFind(int size) {
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

		public boolean union(int x, int y) {
			var rootX = find(x);
			var rootY = find(y);
			if (rootX != rootY) {
				if (ranks[rootX] > ranks[rootY]) {
					roots[rootY] = rootX;
				} else if (ranks[rootX] < ranks[rootY]) {
					roots[rootX] = rootY;
				} else {
					roots[rootY] = rootX;
					ranks[rootX] += 1;
				}
				return true;
			}
			// they point to the same point, and they don't need to perform union
			return false;
		}
	}


	public boolean validTree(int n, int[][] edges) {
		if (edges.length != n - 1) {
			return false;
		}

		UnionFind unionFind = new UnionFind(n);

		for (int[] edge : edges) {
			// 如果兩個點，沒有辦法被連起來，即出現 cycle
			if (!unionFind.union(edge[0], edge[1])) {
				return false;
			}
		}

		return true;
	}
}
