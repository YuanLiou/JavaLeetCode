package sample;

public class QuickUnionPathCompression {
	int[] roots;
	public QuickUnionPathCompression(int size) {
		roots = new int[size];
		for (int i = 0; i < size; i++) {
			roots[i] = i;
		}
	}

	public int find(int x) {
		// base case
		if (x == roots[x]) {
			return x;
		}

		// keeping finding for root vertices
		roots[x] = find(roots[x]);
		return roots[x];
	}

	private void union(int x, int y) {
		var rootX = find(x);
		var rootY = find(y);
		if (rootX != rootY) {
			roots[rootY] = rootX;
		}
	}
	private boolean connected(int x, int y) {
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		QuickUnionPathCompression uf = new QuickUnionPathCompression(10);
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
