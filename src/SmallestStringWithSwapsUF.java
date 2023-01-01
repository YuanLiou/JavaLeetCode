import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmallestStringWithSwapsUF {
	public static void main(String[] args) {
		var sampleClass = new SmallestStringWithSwapsUF();

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

		public int find(int x) {
			if (x == roots[x]) {
				return x;
			}
			roots[x] = find(roots[x]);
			return roots[x];
		}

		public void union(int x, int y) {
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
			}
		}
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		// 1.) Union all the given pairs
		UnionFind unionFind = new UnionFind(s.length());
		for (List<Integer> pair : pairs) {
			unionFind.union(pair.get(0), pair.get(1));
		}

		// 2.) Create a map to make reference both position key and position characters
		Map<Integer, List<Integer>> relationshipMap = new HashMap<>();
		// 找到頂點，並將取得的數字塞到對應的 Index
		for (int position = 0; position < s.length(); position++) {
			// find position's root
			int root = unionFind.find(position);
			// if there is no value for this root, create an new array for it
			relationshipMap.putIfAbsent(root, new ArrayList<>());
			relationshipMap.get(root).add(position);
		}

		// 3.) Create an empty character array, put char one by one through postion we created
		//     aboves
		char[] result = new char[s.length()];
		for (List<Integer> charPositions : relationshipMap.values()) {
			List<Character> pickedCharacters = new ArrayList<>();
			for (int position : charPositions) {
				pickedCharacters.add(s.charAt(position));
			}
			Collections.sort(pickedCharacters); // make it lexicographically
			for (int index = 0; index < pickedCharacters.size(); index++) {
				result[charPositions.get(index)] = pickedCharacters.get(index);
			}
		}

		return new String(result);
	}
}
