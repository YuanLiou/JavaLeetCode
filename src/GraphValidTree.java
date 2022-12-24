import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GraphValidTree {

	public static void main(String[] args) {
		var sampleClass = new GraphValidTree();
		var sample01 = new int[][] {
			{0, 1},
			{0, 2},
			{0, 3},
			{1, 4}
		};
		var sample01N = 5;
		// Expected: true
		var result = sampleClass.validTree03(sample01N, sample01);
		System.out.println("Result is " + result);

		var sample02 = new int[][] {
			{0, 1},
			{1, 2},
			{2, 3},
			{1, 3},
			{1, 4}
		};
		var sample02N = 5;
		// Expected: false
		var result02 = sampleClass.validTree03(sample02N, sample02);
		System.out.println("Result02 is " + result02);
	}

	public boolean validTree01(int n, int[][] edges) {
		// 1.) Build a adjadencyList
		List<List<Integer>> adjadencyList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjadencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			adjadencyList.get(edge[0]).add(edge[1]);
			adjadencyList.get(edge[1]).add(edge[0]);
		}

		// 2-a.) Check duplicated path (Find cycle)
		// 2-b.) Check disconnection
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // the value is from 0 to n - 1

		// A map to check input value's parent
		// root node has no parent, so set it to -1
		Map<Integer, Integer> parent = new HashMap<>();
		parent.put(0, -1);

		while (!stack.isEmpty()) {
			int node = stack.pop();
			// adjadencyList.get(node) ==> List<Int>
			// for ( int : List<Int> )
			// pick every value in list of index
			for (int neighbor : adjadencyList.get(node)) {
				// 2-a.) Check duplicated path (Find cycle)
				// if current node's parent is neighbor, it means it is an upside direction
				if (parent.get(node) == neighbor) {
					continue;
				}

				// 2-b.) We don't walk the duplicated path
				if (parent.containsKey(neighbor)) {
					// if there is a cycle, it must NOT a valid tree
					return false;
				}

				System.out.println("node: " + node + ", neighbor is " + neighbor);
				stack.push(neighbor);
				// Update the parent information of each neighbor nodes.
				parent.put(neighbor, node);
			}
		}

		// We can make sure: We have walked through all nodes without duplicated path
		return parent.size() == n;
	}

	// Approach 01: Naive DFS
	public boolean validTree02(int n, int[][] edges) {
		// 1. make a adjacencyList
		List<List<Integer>> adjacencyList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjacencyList.add(new ArrayList<>());
		}

		// 建立相鄰兩點之間的關係
		for (int[] edge : edges) {
			adjacencyList.get(edge[0]).add(edge[1]);
			adjacencyList.get(edge[1]).add(edge[0]);
		}

		// 2. DFS, walk through all points
		//  Except: if there has a cycle, it WON'T be a tree.
		//  Caution: we don't walk duplicated path.
		//  e.g. A -> B -> C -> D and A -> B -> D -> C
		//  C -> D and D -> C is a trivial path.
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // push the root point

		// build a map which connect a node and its parent node.
		Map<Integer, Integer> parent = new HashMap<>();
		parent.put(0, -1); // root nodes won't have a parent. Also, it has been visited in the beginning

		while (!stack.isEmpty()) {
			int node = stack.pop();
			// Check every neighbor nodes
			for (int neighbor : adjacencyList.get(node)) {
				// Stop condition
				// 1.) Ignore the trivial path
				if (parent.get(node) == neighbor) {
					// 現在這個 node 的 parent 就是 neighbor，直接忽略
					continue;
				}

				// 2.) if there has a cycle, it WON'T be a tree. 直接不用找
				if (parent.containsKey(neighbor)) {
					return false; // There has a cycle
				}

				stack.push(neighbor);
				// 設定這個 neighbor 的 root 是 node.
				parent.put(neighbor, node); // (node) ==> (neighbor)
			}
		}

		// Make sure each node has been visisted.
		return parent.size() == n;
	}

	// Approach 02: Graph theory to know how tree has form
	//  In previous approach, we use a parent, node map to know
	//  there is a cycle...
	public boolean validTree03(int n, int[][] edges) {
		// We know that:
		// A tree MUST form in "n - 1" edges. If not, it might not be a tree
		// or it is a disjoint set.

		// 1. ) Check whether it can form a tree
		if (edges.length != n - 1) {
			return false;
		}

		// After we pass checks above, we can make sure this edges will NOT contain a cycle.

		// 2.) Create a adjancencyList based on all edges
		List<List<Integer>> adjancencyList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjancencyList.add(new ArrayList<>());
		}

		for (int[] edge : edges) {
			// 互相關聯
			adjancencyList.get(edge[0]).add(edge[1]);
			adjancencyList.get(edge[1]).add(edge[0]);
		}

		// 3.) BFS, with Seen set
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);

		// Seen collections, use set here
		Set<Integer> seens = new HashSet<>();
		seens.add(0); // add 頂點, 題目: n is from 0 to n - 1

		while (!queue.isEmpty()) {
			int node = queue.poll();
			// 拜訪鄰居
			for (int neighbor : adjancencyList.get(node)) {
				// Stop condition, trivial path (duplicated path)
				if (seens.contains(neighbor)) {
					continue;
				}

				// Prepare next round
				queue.offer(neighbor);
				seens.add(neighbor);
			}
		}

		// 全走過，即 OK
		return seens.size() == n;
	}
}
