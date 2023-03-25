import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import utils.Node;

public class NaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
	}

	public List<List<Integer>> levelOrder(Node root) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<List<Integer>> result = new ArrayList<>();
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			var layerSize = queue.size();
			var currentIndex = 0;
			List<Integer> currentLayer = new ArrayList<>();
			while (currentIndex < layerSize) {
				var current = queue.poll();
				for (Node neighbor : current.neighbors) {
					queue.offer(neighbor);
				}
				currentLayer.add(current.val);
				
				currentIndex++;

				if (currentIndex == layerSize) {
					result.add(currentLayer);
				}
			}
		}

		return result;
	}

}
