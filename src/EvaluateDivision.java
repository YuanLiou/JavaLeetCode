import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

    public static void main(String[] args) {
    }

    // e.g: [A] --(value)--> [B], towardNodeKey is B, value is value, position is -->
    public record GraphNode(String towardNodeKey, double value){};

    public static double[] calcEquation(
        List<List<String>> equations,
        double[] values,
        List<List<String>> queries
    ) {
        // 1. Make graph
        //  Map<String, List<GraphNode>>
        Map<String, List<GraphNode>> graph = buildGraph(equations, values);

        // 2. Doing calculation (DFS)
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            // dfs 走完題目的：(起點，終點，已走過的點，Graph)
            results[i] = dfs(
                queries.get(i).get(0),
                queries.get(i).get(1),
                new HashSet<String>(),
                graph
            );
        }
        return results;
    }

    private static double dfs(
        String startPosition,
        String destinationPosition,
        HashSet<String> visitedNodes,
        Map<String, List<GraphNode>> graph
    ) {
        // If startPosition and destinationPosition are NOT in the graph, return -1.
        if (!graph.containsKey(startPosition) || !graph.containsKey(destinationPosition)) {
            return -1.0;
        }

        // If startPosition == destinationPosition, return 1.
        if (startPosition.equals(destinationPosition)) {
            return 1.0;
        }

        // otherwise, doing dsf
        visitedNodes.add(startPosition);

        for (GraphNode node : graph.get(startPosition)) {
            if (!visitedNodes.contains(node.towardNodeKey)) {
                // e.g. A graph go from A to C. [A] --> [B] --> [C].
                //  c is the destinationNode, B is A's towardNodeKey.
                // keeping doing dfs
                double answer = dfs(node.towardNodeKey, destinationPosition, visitedNodes, graph);
                if (answer != -1.0) {
                    return answer * node.value;
                }
            }
        }

        // default return -1.0 means we didn't find anything.
        return -1.0;
    }

    private static Map<String, List<GraphNode>> buildGraph(
        List<List<String>> equations,
        double[] values
    ) {
        Map<String, List<GraphNode>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String startPosition = equations.get(i).get(0);
            String destinationPosition = equations.get(i).get(1);

            graph.putIfAbsent(startPosition, new ArrayList<>());
            graph.putIfAbsent(destinationPosition, new ArrayList<>());

            // We know that A -> B is value, start to destination
            graph.get(startPosition).add(new GraphNode(destinationPosition, values[i]));

            // and B -> A is 1 / value, destination to start
            graph.get(destinationPosition).add(new GraphNode(startPosition, 1 / values[i]));
        }

        return graph;
    }
}
