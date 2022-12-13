package sample;

public class QuickUnion {
	int[] roots;

	public QuickUnion(int size) {
		roots = new int[size];
		for (int i = 0; i < size; i++) {
			roots[i] = i;
		}
	}

	public int find(int x) {
		// Find the one whose parent vertex equals to itself
		while (x != roots[x]) {
			x = roots[x];
		}
		return x;
	}

	public void union(int x, int y) {
		var rootX = find(x);
		var rootY = find(y);
		if (rootX != rootY) {
			// Change the parent vertex of roots[rootY] to rootX
			roots[rootY] = rootX;
		}
	}
	private boolean connected(int x, int y) {
		return find(x) == find(y);
	}

	public static void main(String[] args) {
		QuickUnion uf = new QuickUnion(10);
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
