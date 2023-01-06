package variant;

import java.util.*;

public class EvaluateDivisionDSF {
	public static void main(String[] args) {
	}

	private record Path(String towardPoint, double value) {};

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		// 1.) Build graph
		Map<String, List<Path>> equationGraph = buildGraph(equations, values);

		// 2.) Doing dfs to calculate values
		double[] resultValues = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			Set<String> visited = new HashSet<>(); // 每一次的查找，都是一個新的 seen、visited。不會受其他次影響。
			resultValues[i] = dfs(
					query.get(0),
					query.get(1),
					equationGraph,
					visited
			);
		}
		return resultValues;
	}

	private double dfs(
			String start,
			String destination,
			Map<String, List<Path>> equationGraph,
			Set<String> visited
	) {
		// base case:
		// 1.) A point doesnt't existed in start or destination
		if (!equationGraph.containsKey(start) || !equationGraph.containsKey(destination)) {
			return -1.0;
		}

		// 2.) start and destination is itself. (we are in a loop)
		if (start.equals(destination)) {
			return 1.0;
		}

		visited.add(start);
		// 把 start 這個點的 path 都取出
		for (Path path : equationGraph.get(start)) {
			// 找尚未去過的點
			if (!visited.contains(path.towardPoint)) {
				double answer = dfs(
						path.towardPoint,
						destination,
						equationGraph,
						visited
				);

				if (answer != -1.0) {
					return answer * path.value;
				}
			}
		}

		// if can't find anything, return -1.0
		return -1.0;
	}

	private Map<String, List<Path>> buildGraph(List<List<String>> equations, double[] values) {
		Map<String, List<Path>> graph = new HashMap<>();
		for (int i = 0; i < values.length; i++) {
			String startPosition = equations.get(i).get(0);
			String destinationPosition = equations.get(i).get(1);

			graph.putIfAbsent(startPosition, new ArrayList<>());
			graph.putIfAbsent(destinationPosition, new ArrayList<>());

			// We know that A -> B is value, start to destination
			graph.get(startPosition).add(new Path(destinationPosition, values[i]));

			// and B -> A is 1 / value, destination to start
			graph.get(destinationPosition).add(new Path(startPosition, 1 / values[i]));
		}

		return graph;
	}
}
