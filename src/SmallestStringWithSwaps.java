import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestStringWithSwaps {
	public static void main(String[] args) {
		var sampleClass = new SmallestStringWithSwaps();

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

	private String swapString(String source, int i, int j) {
		StringBuilder stringBuilder = new StringBuilder(source);
		stringBuilder.setCharAt(i, source.charAt(j));
		stringBuilder.setCharAt(j, source.charAt(i));
		return stringBuilder.toString();
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

		public void union(int x, int y) {
			var rootX = find(x);
			var rootY = find(y);
			if (ranks[rootX] > ranks[rootY]) {
				roots[rootY] = rootX;
			} else if (ranks[rootX] < ranks[rootY]) {
				roots[rootX] = rootY;
			} else {
				roots[rootY] = rootX;
				ranks[rootX] += 1;
			}
		}
		public int getGroupCounts() {
			Set<Integer> arrayRoots = new HashSet<>();
			for (int rootValue : roots) {
				arrayRoots.add(find(rootValue));
			}
			return arrayRoots.size();
		}
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		// Find out if there is a connection point between two node in pairs
		var size = s.length();
		var unionFind = new UnionFind(size);
		for (List<Integer> pair : pairs) {
			unionFind.union(pair.get(0), pair.get(1));
		}

		if (unionFind.getGroupCounts() > 1) {
			// compare its ASCII code value of each pairs
			String result = s;
			for (List<Integer> pair : pairs) {
				char charA = result.charAt(pair.get(0));
				char charB = result.charAt(pair.get(1));
				// first one's ASCII code MUST smaller than the second one.
				if (charA > charB) {
					result = swapString(result, pair.get(0), pair.get(1));
				}
			}
			return result;
		}

		// Somewhat is connected, at least one connection
		// sort string lexicographically
		String result = s;
		for (int i = 0; i < result.length(); i++) {
			for (int j = i + 1; j < result.length(); j++) {
				char charA = result.charAt(i);
				char charB = result.charAt(j);
				// first one's ASCII code MUST smaller than the second one.
				if (charA > charB) {
					result = swapString(result, i, j);
				}
			}
		}
		return result;
	}
}
