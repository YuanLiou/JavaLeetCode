import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestStringWithSwapsDFS {
	public static void main(String[] args) {
		 var sampleClass = new SmallestStringWithSwapsDFS();

		 // Sample01: dcab
		 var sample01 = "dcab";
		 var sampleInput01 = new ArrayList<List<Integer>>();
		 sampleInput01.add(List.of(0, 3));
		 sampleInput01.add(List.of(1, 2));
		 sampleInput01.add(List.of(0, 2));

		 // Expected: "abcd"
		 var result = sampleClass.smallestStringWithSwaps(sample01, sampleInput01);
		 System.out.println("Result is " + result);
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		// 1.) create adjacencyList
		int maxSize = 100001;
		boolean[] visited = new boolean[maxSize];
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (List<Integer> edge : pairs) {
			adjacencyList.get(edge.get(0)).add(edge.get(1));
			adjacencyList.get(edge.get(1)).add(edge.get(0));
		}

		// 2.) doing dfs and put char and position into lists
		char[] result = new char[s.length()];
		for (int vertices = 0; vertices < s.length(); vertices++) {
			if (visited[vertices]) {
				continue;
			}
			
			List<Character> characters = new ArrayList<>();
			List<Integer> positions = new ArrayList<>();

			// doing dfs
			dfs(s, vertices, characters, positions, visited, adjacencyList);

			// recreate a string and sorted it with lexicographically sort
			Collections.sort(characters);
			Collections.sort(positions);
			for (int i = 0; i < characters.size(); i++) {
				result[positions.get(i)] = characters.get(i);
			}
		}
		return new String(result);
	}

	private void dfs(
			String s,
			int vertices,
			List<Character> characters,
			List<Integer> positions,
			boolean[] visited,
			List<List<Integer>> adjacencyList
	) {
		// base case: isVisited
		visited[vertices] = true;

		characters.add(s.charAt(vertices));
		positions.add(vertices);

		List<Integer> neighbors = adjacencyList.get(vertices);
		for (int vertice : neighbors) {
			// stop condition, this if statement
			if (!visited[vertice]) {
				dfs(s,
						vertice,
						characters,
						positions,
						visited,
						adjacencyList
				);
			}
		}
	}
}
