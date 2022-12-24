import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphValidTreeDfs {

	public static void main(String[] args) {
		var sampleClass = new GraphValidTreeDfs();
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

	Set<Integer> seen = new HashSet<>();
	// Approach 02: Graph theory to know how tree has form
	//  based on BFS recursive
	public boolean validTree(int n, int[][] edges) {
		// 1. ) Check Whether the given edges are able to form a tree?
		if (edges.length != n - 1) {
			return false;
		}

		// We make sure there won't be a cycle if no return

		// 2. ) Create a adjacencyList
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		// 建立關係
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// 3. ) dfs to traversal all nodes
		traversalDfs(0, adjacencyList);
		return seen.size() == n;
	}

	private void traversalDfs(int node, List<List<Integer>> adjacencyList) {
		// base case: stop condition
		if (seen.contains(node)) {
			return;
		}
		seen.add(node);
		
		for (int neighbor : adjacencyList.get(node)) {
			traversalDfs(neighbor, adjacencyList);
		}
	}
}
