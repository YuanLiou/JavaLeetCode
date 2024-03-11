import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReachableNodesWithRestrictions {
	public static void main(String[] args) {
		var sampleClass = new ReachableNodesWithRestrictions();
		int[][] edges01 = {
				{0,1},
				{1,2},
				{3,1},
				{4,0},
				{0,5},
				{5,6}
		};
		int[] restricted01 = {4, 5};
		// expected = 4
		var answer001 = sampleClass.reachableNodes(7, edges01, restricted01);
		System.out.println("Answer 001 is " + answer001);

		int[][] edges002 = {
				{0,1},
				{0,2},
				{0,5},
				{0,4},
				{3,2},
				{6,5}
		};
		int[] restricted002 = {4, 2, 1};

		// expected = 3
		var answer002 = sampleClass.reachableNodes(7, edges002, restricted002);
		System.out.println("Answer 002 is " + answer002);
	}

	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		// build adjacency list
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// restricted
		Set<Integer> restrictedSet = new HashSet<>();
		for (int restrictedNumber : restricted) {
			restrictedSet.add(restrictedNumber);
		}

		Set<Integer> visited = new HashSet<>();
		traverse(adjacencyList, 0, restrictedSet, visited);
		return visited.size();
	}

	private void traverse(List<List<Integer>> adjacencyList,
	                     int current,
	                     Set<Integer> restrictedSet,
	                     Set<Integer> visited) {
		if (restrictedSet.contains(current)) {
			return;
		}

		if (visited.contains(current)) {
			return;
		}
		visited.add(current);

		for (int next : adjacencyList.get(current)) {
			if (restrictedSet.contains(next)) {
				continue;
			}
			traverse(adjacencyList, next, restrictedSet, visited);
		}
	}
}
