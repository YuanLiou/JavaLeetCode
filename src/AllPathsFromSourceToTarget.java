import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	public static void main(String[] args) {
		var sampleClass = new AllPathsFromSourceToTarget();
		var example01 = new int[][]{{1, 2}, {3}, {3}, {},};
		var result = sampleClass.allPathsSourceTargetBFS(example01);

		for (List<Integer> list : result) {
			for (int number : list) {
				System.out.print("" + number + ", ");
			}
		}

	}

	public List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
		// base case: whether input graph is valid
		if (graph == null || graph.length == 0) {
			return Collections.emptyList();
		}

		// 1.) create the result list and the initial path list
		List<List<Integer>> resultList = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>(); // for quick doing removeLast()

		// 2.) doing dsf
		dfs(0, graph, path, resultList);
		return resultList;
	}

	private void dfs(int currentNode, int[][] graph, LinkedList<Integer> path, List<List<Integer>> resultList) {
		path.add(currentNode);
		// base case: we're in the base case
		if (currentNode == graph.length - 1) {
			resultList.add(new ArrayList<>(path));
			return;
		}

		for (int neighbor : graph[currentNode]) {
			dfs(neighbor, graph, path, resultList);
			path.removeLast(); // backtracking
		}
	}

	public List<List<Integer>> allPathsSourceTargetBFS(int[][] graph) {
		if (graph == null || graph.length == 0) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<>();
		ArrayDeque<List<Integer>> queue = new ArrayDeque<>();

		// Start our first journey
		List<Integer> currentPath = new ArrayList<>();
		currentPath.add(0); // We always start from 0
		queue.push(currentPath); // Push the first step to the queue

		// Doing BFS
		while (!queue.isEmpty()) {
			var current = queue.poll();
			// we need to get the final step of current path to find next step where to go.
			var currentNumber = current.get(current.size() - 1);
			if (currentNumber == graph.length - 1) {
				// we have found the destination
				result.add(current);
				continue;
			}

			// Find out all numbers in adjacency list
			for (int nextNumber : graph[currentNumber]) {
				List<Integer> nextPath = new ArrayList<>(current);
				nextPath.add(nextNumber);
				queue.push(nextPath);
			}
		}
		return result;
	}
}
