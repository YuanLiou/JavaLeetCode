import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {

	public static void main(String[] args) {
		var sampleClass = new MinCostToConnectAllPoints();
		int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
		System.out.print("Minimum Cost to Connect Points = ");
		// Expected: 20
		System.out.println(sampleClass.minCostConnectPointsPrim(points));
	}

	public int minCostConnectPointsPrim(int[][] points) {
		// base case
		if (points == null || points.length == 0) {
			return 0;
		}

		// prepare basic parameters
		int size = points.length;
		// PriorityQueue
		PriorityQueue<PathCost> pathCosts = new PriorityQueue<>(new Comparator<PathCost>() {
			@Override
			public int compare(PathCost cost01, PathCost cost02) {
				return cost01.cost - cost02.cost;
			}
		});
		// A visited array
		boolean[] visited = new boolean[size];
		Arrays.fill(visited, false);

		// Build an adjacency list
		// build up PathCost based on the first node
		// so the first value (which is x) in PathCost would always be 0
		int[] coordinates01 = points[0];
		// The point won't connect to itself, so start at 1
		for (int j = 1; j < size; j++) {
			int[] coordinates02 = points[j];
			// calculation based on the question's equation.
			int cost =
					Math.abs(coordinates01[0] - coordinates02[0]) +
					Math.abs(coordinates01[1] - coordinates02[1]);

			pathCosts.add(new PathCost(0, j, cost));
		}
		visited[0] = true;

		// Calculate the cost
		int cost = 0;
		int step = size - 1;
		while (!pathCosts.isEmpty() && step > 0) {
			var current = pathCosts.poll();
			if (!visited[current.y]) {
				visited[current.y] = true;
				cost += current.cost;

				// build up other points which connected with current one
				int[] neighbor01 = points[current.y];
				for (int j = 0; j < size; j++) {
					// The point won't connect to itself, so start at (j != current.y)
					if (!visited[j] && j != current.y) {
						int[] neighbor02 = points[j];
						// calculation based on the question's equation.
						int neighborCost =
								Math.abs(neighbor01[0] - neighbor02[0]) +
										Math.abs(neighbor01[1] - neighbor02[1]);
						pathCosts.add(new PathCost(current.y, j, neighborCost));
					}
				}

				step--;
			}
		}

		return cost;
	}

	// Kruskal's Algorithm
	public int minCostConnectPointsKruskal(int[][] points) {
		// base case
		if (points == null || points.length == 0) {
			return 0;
		}

		// prepare basic parameters
		int size = points.length;
		PriorityQueue<PathCost> pathCosts = new PriorityQueue<>(new Comparator<PathCost>() {
			@Override
			public int compare(PathCost cost01, PathCost cost02) {
				return cost01.cost - cost02.cost;
			}
		});
		UnionFind unionFind = new UnionFind(size);

		// build up PathCost
		// Base on single point, calculate starts from its next point to the last point
		//  then update the single point to its next.
		for (int i = 0; i < size; i++) {
			int[] coordinates01 = points[i];
			for (int j = i + 1; j < size; j++) {
				int[] coordinates02 = points[j];
				// calculation based on the question's equation.
				int cost = Math.abs(coordinates01[0] - coordinates02[0]) + Math.abs(coordinates01[1] - coordinates02[1]);
				pathCosts.add(new PathCost(i, j, cost));
			}
		}

		// Calculate the cost
		int cost = 0;
		int step = size - 1;
		while (!pathCosts.isEmpty() && step > 0) {
			var current = pathCosts.poll();
			if (!unionFind.isConnected(current.x, current.y)) {
				unionFind.union(current.x, current.y);
				cost += current.cost;
				step--;
			}
		}

		return cost;
	}

	record PathCost(int x, int y, int cost) {};
	class UnionFind {
		private int[] roots;
		private int[] ranks;

		UnionFind(int size) {
			roots = new int[size];
			ranks = new int[size];
			for (int i = 0; i < size; i++) {
				roots[i] = i;
				ranks[i] = 1;
			}
		}

		int find(int x) {
			if (x == roots[x]) {
				return x;
			}
			roots[x] = find(roots[x]);
			return roots[x];
		}

		void union(int x, int y) {
			var rootX = find(x);
			var rootY = find(y);
			if (rootX == rootY) {
				return;
			}
			
			if (ranks[x] > ranks[y]) {
				roots[rootY] = rootX;
			} else if (ranks[x] < ranks[y]) {
				roots[rootX] = rootY;
			} else {
				roots[rootX] = rootY;
				ranks[rootX] += 1;
			}
		}

		boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
	}
}
