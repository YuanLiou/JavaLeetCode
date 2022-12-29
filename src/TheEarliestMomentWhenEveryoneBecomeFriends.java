import java.util.*;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
	public static void main(String[] args) {
	}

	private class UnionFind {
		int[] roots;
		int[] ranks;
		int groups;

		UnionFind(int size) {
			roots = new int[size];
			ranks = new int[size];
			groups = size - 1;
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

		public int union(int x, int y) {
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
				groups = groups - 1;
			}
			return groups;
		}
	}

	public int earliestAcq(int[][] logs, int n) {
		// building content
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		for (int[] log : logs) {
			List<Integer> contents = new ArrayList<>();
			int[] contentsArray = Arrays.copyOfRange(log,1, log.length);
			for (int value : contentsArray) {
				contents.add(value);
			}
			map.put(log[0], contents);
		}

		UnionFind unionFind = new UnionFind(n);
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			var currentPair = entry.getValue();
			var result = unionFind.union(currentPair.get(0), currentPair.get(1));
			if (result == 0) {
				return entry.getKey();
			}
		}
		return -1;
	}
}
