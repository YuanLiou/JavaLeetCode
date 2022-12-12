package sample;

public class QuickFind {
	int[] roots;
	public QuickFind(int size) {
		roots = new int[size];
		for (int i = 0; i < size; i++) {
			roots[i] = i;
		}
	}

	public int find(int x) {
		return roots[x];
	}

	public boolean connected(int x, int y) {
		return roots[x] == roots[y];
	}

	public void union(int x, int y) {
		int rootX = roots[x];
		int rootY = roots[y];
		if (rootX != rootY) {
			// Change y's root to x if they are not in the same root.
			// Iterate all vertices whose root is y, need to change to x
			for (int i = 0; i < roots.length; i++) {
				if (roots[i] == rootY) {
					roots[i] = rootX;
				}
			}
		}
	}

	public static void main(String[] args) {
		QuickFind uf = new QuickFind(10);
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
