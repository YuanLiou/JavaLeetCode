public class FindPathExistsGraph {
	public static void main(String[] args) {
	}

	public boolean validPathUF(int n, int[][] edges, int source, int destination) {
		UnionFind unionFind = new UnionFind(n);
		for (int[] edge : edges) {
			unionFind.union(edge[0], edge[1]);
		}
		return unionFind.isConnected(source, destination);
	}

	private class UnionFind {
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


	public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
		return true;
	}

}
