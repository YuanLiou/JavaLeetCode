import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllPathsSourceLeadToDestination {
	public static void main(String[] args) {
		// expected: true
		int[][] sample01 = new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}};
		var source01 = 0;
		var destination01 = 3;
		var numberSize01 = 4;

		// expected: false
		int[][] sample02 = new int[][]{{0, 1}, {0, 2}};
		var source02 = 0;
		var destination02 = 2;
		var numberSize02 = 3;

		// expected: false
		int[][] sample03 = new int[][]{{0, 1}, {0, 3}, {1, 2}, {2, 1}};
		var source03 = 0;
		var destination03 = 3;
		var numberSize03 = 4;

		var sampleClass = new AllPathsSourceLeadToDestination();
		var result = sampleClass.leadsToDestination(numberSize01, sample01, source01, destination01);
		System.out.println("Result is " + result);
	}
	public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		// 1. build adjacencyList
		List<List<Integer>> adjacencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
		}
		
		return isValidPath(source, destination, adjacencyList, new NodeColor[n]);
	}

	enum NodeColor {
		GRAY, BLACK;
	}

	private boolean isValidPath(
			int current,
			int destination,
			List<List<Integer>> graph,
			NodeColor[] nodeStatus
	) {
		// base case
		// check if current node is a gray node.
		// it's means we meet a node which is processing currently. It has a cycle in this graph.
		if (nodeStatus[current] != null) {
			// node is not white
			return nodeStatus[current] == NodeColor.BLACK; // meet black one is a valid path
		}

		// check whether current node has any neighbors?
		if (graph.get(current).isEmpty()) {
			return current == destination; // if this node is the destination, is a valid path
		}

		// set current node to gray. It is means we're processing it.
		nodeStatus[current] = NodeColor.GRAY;

		for (int nextTarget : graph.get(current)) {
			var isValidPath = isValidPath(
					nextTarget,
                    destination,
                    graph,
                    nodeStatus
			);
			if (!isValidPath) {
				return false;
			}
		}

		// set current node to black. It is means we're done processing.
		nodeStatus[current] = NodeColor.BLACK;
		return true;
	}

	// To find whether is a cycle in the graph
	private boolean isValidPath02(
			int current,
			int destination,
			List<List<Integer>> graph,
			HashSet<Integer> visited
	) {
		// 停止條件：
		// 1. (true) 目前的點是 destination AND destination 沒有其他路徑
		// 2. (false)目前的點是 destination AND destination 有其他路徑 => 有循環
		// 3. (false)目前的點不是 destination AND 這個點「沒有」其他路徑 => 無法走過所有點
		// 4. (false)目前的點已經被訪問過 => 有循環
		if (visited.contains(current)) {
			return false;
		}

		if (current == destination && graph.get(destination).isEmpty()) {
			return true;
		}

		if (current == destination && !graph.get(destination).isEmpty()) {
			return false;
		}

		if (current != destination && graph.get(current).isEmpty()) {
			return false;
		}

		visited.add(current); // set current node a seen node
		for (int nextDestination : graph.get(current)) {
			var isValidPath = isValidPath02(
					nextDestination,
					destination,
					graph,
					visited
			);
			if (!isValidPath) {
				return false;
			}
		}

		visited.remove(current); // backtracking
		return true;
	}
}
