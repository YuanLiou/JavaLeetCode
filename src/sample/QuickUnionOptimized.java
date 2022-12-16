package sample;

public class QuickUnionOptimized {
	int[] roots;
	int[] ranks;
	public QuickUnionOptimized(int size) {
		roots = new int[size];
		ranks = new int[size];
		for (int i = 0; i < size; i++) {
			roots[i] = i;
			ranks[i] = 1;
		}
	}

	// Path compression
	public int find(int x) {
		if (x == roots[x]) {
			return x;
		}

		x = find(roots[x]);
		return x;
	}

	// Union by rank
	private void union(int x, int y) {
		var rootX = find(x);
		var rootY = find(y);
		if (rootX != rootY) {
			// Compare their ranks
			if (ranks[x] > ranks[y]) {
				roots[rootY] = rootX;
			} else if (ranks[x] < ranks[y]) {
				roots[rootX] = rootY;
			} else {
				roots[rootY] = rootX;
				ranks[rootX] += 1;
			}
		}
	}

	private boolean connected(int x, int y) {
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		QuickUnionOptimized uf = new QuickUnionOptimized(10);
		// 1-2-5-6-7 3-8-9 4
		uf.union(1, 2);
		uf.union(2, 5);
		uf.union(5, 6);
		uf.union(6, 7);
		uf.union(3, 8);
		uf.union(8, 9);
		System.out.println(uf.connected(1, 5)); // true
		System.out.println(uf.connected(5, 7)); // true
		System.out.println(uf.connected(4, 9)); // false
		// 1-2-5-6-7 3-8-9-4
		uf.union(9, 4);
		System.out.println(uf.connected(4, 9)); // true
	}
}
