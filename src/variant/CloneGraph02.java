package variant;

import java.util.*;

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
public class CloneGraph02 {
	public Node cloneGraph(Node node) {
		// base case check
		if (node == null) {
			return null;
		}

		Map<Integer, Node> seen = new HashMap<>();
		return dfs(node, seen);
	}

	private Node dfs(Node currentNode, Map<Integer, Node> seen) {
		// Base case: if there has already a node in map
		if (seen.containsKey(currentNode.val)) {
			return seen.get(currentNode.val);
		}

		Node copied = new Node(currentNode.val);
		seen.put(currentNode.val, copied);
		for (Node node : currentNode.neighbors) {
			 Node neigibor = dfs(node, seen);
			 copied.neighbors.add(neigibor);
		}
		return copied;
	}
}
