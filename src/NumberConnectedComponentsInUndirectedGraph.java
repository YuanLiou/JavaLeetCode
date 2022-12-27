import java.util.HashSet;
import java.util.Set;

public class NumberConnectedComponentsInUndirectedGraph {
	public static void main(String[] args) {
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

		public int getGroupCounts() {
			Set<Integer> rootCounts = new HashSet<Integer>();
			for (int i = 0; i < roots.length; i++) {
				rootCounts.add(find(roots[i]));
			}
			return rootCounts.size();
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
			if (rootX != rootY) {
				if (ranks[rootX] > ranks[rootY]) {
					roots[rootY] = rootX;
				} else if (ranks[rootX] < ranks[rootY]) {
					roots[rootX] = rootY;
				} else {
					roots[rootY] = rootX;
					ranks[rootX] += 1;
				}
			}
		}
	}

	public int countComponents(int n, int[][] edges) {
		UnionFind unionFind = new UnionFind(n);
		for (int[] edge : edges) {
			unionFind.union(edge[0], edge[1]);
		}
		return unionFind.getGroupCounts();
	}
}
