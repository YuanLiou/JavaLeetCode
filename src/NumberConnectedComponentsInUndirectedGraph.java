import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

	public int countComponentsDfs(int n, int[][] edges) {
		// setup parameters
		int componentsCount = 0;
		boolean[] seens = new boolean[n];

		// create adjacencyList
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// DFS
		for (int i = 0; i < n; i++) {
			if (!seens[i]) {
				componentsCount++;
				dfs(adjacencyList, seens, i);
			}
		}

		return componentsCount;
	}

	private void dfs(List<List<Integer>> adjacencyList, boolean[] seens, int start) {
		// update seens
		seens[start] = true;

		// dfs
		var neighbors = adjacencyList.get(start);
		for (int i = 0; i < neighbors.size(); i++) {
			//  stop condition(base case), this start point has been seen, so we can ignore it
			var currentNumber = neighbors.get(i);
			if (!seens[currentNumber]) {
				dfs(adjacencyList, seens, currentNumber);
			}
		}
	}

	// My second try

	private int counts = 0;

	public int countComponentsTry2(int n, int[][] edges) {
		// build adjacencyList
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// build up a seen HashSet
		Set<Integer> seen = new HashSet<>();

		// DFS: walkthrough
		for (int i = 0; i < n; i++) {
			walkthrough(i, adjacencyList, i, seen);
		}
		return counts;
	}

	private void walkthrough(int start, List<List<Integer>> adjacencyList, int current, Set<Integer> seen) {
		if (seen.contains(current)) {
			return;
		}
		seen.add(current);
		if (start == current) {
			counts++;
		}

		for (Integer number : adjacencyList.get(current)) {
			walkthrough(start, adjacencyList, number, seen);
		}
	}
}
