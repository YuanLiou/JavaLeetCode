import java.util.*;

public class ReconstructItinerary {
	public List<String> findItinerary(List<List<String>> tickets) {
		// Create an adjacency list
		Map<String, LinkedList<String>> adjacencyList = new HashMap<>();
		for (List<String> path : tickets) {
			if (adjacencyList.containsKey(path.get(0))) {
				adjacencyList.get(path.get(0)).add(path.get(1));
			} else {
				LinkedList<String> newList = new LinkedList<>();
				newList.add(path.get(1));
				adjacencyList.put(path.get(0), newList);
			}
		}

		// Sort the content with lexical order
		for (Map.Entry<String, LinkedList<String>> entry : adjacencyList.entrySet()) {
			Collections.sort(entry.getValue());
		}

		// Find Itinerary
		LinkedList<String> result = new LinkedList<>();
		dfs(adjacencyList, "JFK", result);
		return result;
	}

	private void dfs(
		Map<String, LinkedList<String>> adjacencyList,
		String current,
		LinkedList<String> result
	) {
		var destinations = adjacencyList.get(current);
		if (destinations == null || destinations.isEmpty()) {
			result.addFirst(current);
			return;
		}

		// go through all the destination of current adjacencyList
		while(!adjacencyList.get(current).isEmpty()) {
			String nextDestination = adjacencyList.get(current).removeFirst();
			dfs(adjacencyList, nextDestination, result);
		}
		result.addFirst(current);
	}
}
