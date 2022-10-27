import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

import utils.TreeNode;

public class KthLargestElementInStream {
	public static void main(String[] args) {
	}

	private TreeNode node;
	private int kthLargest;

    public KthLargestElementInStream(int k, int[] nums) {
        this.kthLargest = k;
		for (int number : nums) {
			node = insert(node, number);
		}
    }

    public int add(int val) {
        node = insert(node, val);
		var result = printValue(node);
		return result.get(result.size() - kthLargest);
    }

    private TreeNode insert(TreeNode root, int value) {
		if (root == null) {
			return new TreeNode(value);
		}

		if (root.val >= value) {
			// 1.) Input value is smaller than the root value, insert left
			TreeNode node = insert(root.left, value);
			if (node != root) {
				// We're in the leaf
				root.left = node;
			}
		}

		if (root.val < value) {
			// 2.) Input value is larger than the root value, insert right
			TreeNode node = insert(root.right, value);
			if (node != root) {
				// We're in the leaf
				root.right = node;
			}
		}
		return root;
	}

	private List<Integer> printValue(TreeNode root) {
		// in order traverse: l-n-r
		ArrayDeque<TreeNode> stacks = new ArrayDeque<>();
		TreeNode currentNode = root;
		List<Integer> result = new ArrayList<>();

		while (currentNode != null || !stacks.isEmpty()) {
			// 1.) Find very left
			while (currentNode != null) {
				stacks.push(currentNode);
				currentNode = currentNode.left;
			}

			// 2.) Visit itself
			TreeNode popNode = stacks.pop();
			result.add(popNode.val);

			// 3.) Point to the right one
			currentNode = popNode.right;
		}
		return result;
	}
}
