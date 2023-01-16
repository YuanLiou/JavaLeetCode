import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindPathExistsGraph {
	public static void main(String[] args) {
		var sampleClass = new FindPathExistsGraph();
		var sampleArray = new int[][]{};
		var result = sampleClass.validPathDFS(1, sampleArray, 0, 0);
		System.out.println("Result is " + result);

		var sampleArray02 = new int[][]{
				{4, 3}, {1, 4}, {4, 8}, {1, 7}, {6, 4}, {4, 2}, {7, 4}, {4, 0}, {0, 9}, {5, 4}
		};
		var result02 = sampleClass.validPathDFS(10, sampleArray02, 5, 9);
		System.out.println("Result is " + result02);
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

	private boolean hasValidPath = false;
	public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
		// 1. create an adjacency list
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// 2.) create a 'seen' data structure
		Set<Integer> seen = new HashSet<>();

		// 3.) doing dfs
		dfs(source, destination,  adjacencyList, seen);
		return hasValidPath;
	}
	private void dfs(int currentNode, int destination, List<List<Integer>> adjacencyList, Set<Integer> seen) {
		// base case: is seen this point
		if (seen.contains(currentNode)) {
			return;
		}
		seen.add(currentNode);

		// or it is the source --(n nodes...) -> destination path
		if (currentNode == destination) {
			hasValidPath = true;
			return;
		}

		// get its neighbors
		for (int neighbor : adjacencyList.get(currentNode)) {
			// stop if path is equal to source to destination or vise versa.
			dfs(neighbor, destination, adjacencyList, seen);
		}
	}
}
