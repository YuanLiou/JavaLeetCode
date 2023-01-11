import java.util.*;

public class OptimizeWaterDistributionInVillage {
	public static void main(String[] args) {
	}

	private record BuildingPipe(int vertices01, int vertices02, int cost) {}
	public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
		// 1.) prepare node ArrayList for the cost of building wells itself
		List<BuildingPipe> nodes = new ArrayList<>(wells.length + pipes.length + 1);

		// 2.) Created vertial nodes represented the cost of build itself
		for (int i = 0; i < wells.length; i++) {
			// 0 --> (i + 1), e.g. 0 --> 1 的點，成本是 wells[0]
			nodes.add(new BuildingPipe(0, i + 1, wells[i]));
		}

		// 3.) Add rest of all nodes
		for (int i = 0; i < pipes.length; i++) {
			int[] pipeCost = pipes[i];
			nodes.add(new BuildingPipe(pipeCost[0], pipeCost[1], pipeCost[2]));
		}

		// 4.) Sort by its cost
		Collections.sort(nodes, new Comparator<BuildingPipe>() {
			@Override
			public int compare(BuildingPipe buildingPipe01, BuildingPipe buildingPipe02) {
				return buildingPipe01.cost - buildingPipe02.cost;
			}
		});

		// 5.) Doing Union-Find
		UnionFind unionFind = new UnionFind(n + 1);
		int minimumCost = 0;
		for (BuildingPipe buildingPipe : nodes) {
			if (unionFind.union(buildingPipe.vertices01, buildingPipe.vertices02)) {
				minimumCost += buildingPipe.cost;
			}
		}
		return minimumCost;
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

		public boolean union(int x, int y) {
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
				return true;
			}
			return false;
		}
	}
}
