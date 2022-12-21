public class NumberOfProvinces {
	public static void main(String[] args) {
		var sampleClass = new NumberOfProvinces();
		var sample01 = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
		// Expected: 1
		var result = sampleClass.findCircleNum(sample01);
		System.out.println("");
		System.out.println("Result is " + result);
	}

	public int findCircleNum(int[][] isConnected) {
		var connected = new UnionFind(isConnected.length);
		for (int i = 0; i < isConnected.length; i++) {
			for (int j = 0; j < isConnected[i].length; j++) {
				if (i != j && isConnected[i][j] == 1) {
					connected.union(i, j);
				}
			}
		}
		return connected.counts;
	}

	private class UnionFind {
		int[] roots;
		int[] ranks;
		int counts;

		public UnionFind(int size) {
			roots = new int[size];
			ranks = new int[size];
			counts = size;

			for (int i = 0; i < size; i++) {
				roots[i] = i;
				ranks[i] = 1;
			}
		}

		public int find(int x) {
			if (x == roots[x]) {
				return x;
			}

			roots[x] = find(roots[x]);
			return roots[x];
		}

		public void union(int x, int y) {
			int rootX = find(x);
			int rootY = find(y);
			if (rootX != rootY) {
				if (ranks[x] > ranks[y]) {
					roots[rootY] = rootX;
				} else if (ranks[x] < ranks[y]) {
					roots[rootX] = rootY;
				} else {
					roots[rootY] = rootX;
					ranks[rootX] += 1;
				}
				counts--;
			}
		}
	}
}
