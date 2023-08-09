import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetonateTheMaximumBombs {
	public static void main(String[] args) {
		var sampleClass = new DetonateTheMaximumBombs();
		// expected: 1
		var sampleInput = new int[][] {
			{1, 1, 5},
			{10, 10, 5}
		};
//		var result01 = sampleClass.maximumDetonation(sampleInput);
//		System.out.println("Result is " + result01);

		// expected: 7
		int[][] sampleInput02 = {
				{647, 457, 91}, {483, 716, 37}, {426, 119, 35}, {355, 588, 40}, {850, 874, 49},
				{232, 568, 46}, {886, 1, 30}, {54, 377, 3}, {933, 986, 50}, {305, 790, 49},
				{372, 961, 67}, {671, 314, 58}, {577, 221, 29}, {380, 147, 91}, {600, 535, 1},
				{806, 329, 64}, {536, 753, 18}, {906, 88, 23}, {436, 783, 82}, {652, 674, 45},
				{449, 668, 20}, {419, 13, 66}, {853, 767, 60}, {169, 288, 33}, {871, 608, 66},
				{337, 445, 35}, {388, 623, 39}, {723, 503, 81}, {14, 19, 19}, {98, 648, 72},
				{147, 565, 93}, {655, 434, 1}, {407, 663, 22}, {805, 947, 83}, {942, 160, 70},
				{959, 496, 93}, {30, 988, 53}, {187, 849, 60}, {980, 483, 41}, {663, 150, 76},
				{268, 39, 50}, {513, 522, 75}, {61, 450, 90}, {115, 231, 12}, {346, 304, 74},
				{385, 540, 23}, {905, 178, 19}, {336, 896, 81}, {751, 811, 94}, {527, 783, 78},
				{635, 965, 19}, {334, 290, 39}, {748, 460, 77}, {414, 134, 22}, {955, 485, 29},
				{925, 787, 43}, {243, 771, 75}, {675, 223, 29}, {788, 618, 82}, {462, 544, 30},
				{999, 259, 50}, {210, 146, 12}, {789, 442, 70}, {286, 36, 55}, {451, 953, 6},
				{719, 914, 14}, {664, 452, 14}, {933, 637, 29}, {206, 926, 16}, {100, 422, 98},
				{97, 333, 4}, {505, 631, 26}, {908, 287, 65}, {907, 316, 86}, {949, 185, 16},
				{639, 735, 62}, {401, 739, 18}, {605, 926, 21}, {25, 391, 69}, {80, 24, 9},
				{435, 874, 92}, {940, 381, 18}, {260, 740, 87}, {727, 515, 17}, {361, 152, 16},
				{512, 470, 67}, {189, 27, 27}, {517, 439, 94}, {159, 543, 76}, {373, 698, 38},
				{781, 836, 97}, {584, 190, 23}, {383, 367, 86}, {825, 141, 63}, {117, 926, 85},
				{169, 588, 60}, {56, 981, 100}, {294, 716, 100}, {781, 370, 89}, {373, 44, 78}
		};
		var result02 = sampleClass.maximumDetonation(sampleInput02);
		System.out.println("Result is " + result02);
	}

	public int maximumDetonation(int[][] bombs) {
		// 1. build an adjacency list
		List<List<Integer>> adjacencyList = new ArrayList<List<Integer>>();
		for (int i = 0; i < bombs.length; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		for (int i = 0; i < bombs.length; i++) {
			// the length(畢氏定理) between two nodes are include in one of its radius
			// then we should add it to our adjacency list
			for (int j = i + 1; j < bombs.length; j++) {
				int x1 = bombs[i][0];
				int y1 = bombs[i][1];
				int r1 = bombs[i][2];

				int x2 = bombs[j][0];
				int y2 = bombs[j][1];
				int r2 = bombs[j][2];

				int xDistance = x1 - x2;
				int yDistance = y1 - y2;
				// sqrt(pow + pow) 平方加平方再開方
				double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

				if (distance <= r1) {
					// distance from i to j is in i's radius
					adjacencyList.get(i).add(j);
				}

				if (distance <= r2) {
					// distance from j to i is in j's radius
					adjacencyList.get(j).add(i);
				}
			}
		}

		// 2. dfs every nodes
		//  2-1 dfs functions
		int maximum = 0;
		//  scan through all nodes
		for (int i = 0; i < bombs.length; i++) {
			int current = dfs(adjacencyList, i, new HashSet<>());
			maximum = Math.max(current, maximum);
		}
		return maximum;
	}

	private int dfs(
			List<List<Integer>> adjacencyList,
			int current,
			Set<Integer> visited
	) {
		if (visited.contains(current)) {
			return 0;
		}

		visited.add(current);
		// scan it's neighbors
		for (int neighbors : adjacencyList.get(current)) {
			dfs(adjacencyList, neighbors, visited);
		}
		return visited.size(); // return how many point it visited
	}
}
