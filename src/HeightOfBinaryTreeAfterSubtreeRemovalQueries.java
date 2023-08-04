import utils.ArrayUtils;
import utils.TreeNode;

import java.util.*;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {
	public static void main(String[] args) {
		var sampleClass = new HeightOfBinaryTreeAfterSubtreeRemovalQueries();
		var node = TreeNode.arrayToBinaryTree(
				new Integer[]{1, 3, 4, 2, null, 6, 5, null, null, null, null, null, 7}
		);
		var queries = new int[]{4};
		var answers = sampleClass.treeQueries(node, queries);
		ArrayUtils.printArray(answers);
	}

	private int[] depths = new int[100001];
	private int[] heights = new int[100001];
	private Map<Integer, List<Integer>> depthToHeightGroup = new HashMap<>();

	public int[] treeQueries(TreeNode root, int[] queries) {
		// DFS: Height
		traverseHeight(root, 0);

		// 先把每層的數值由大至小排列
		for (List<Integer> heights : depthToHeightGroup.values()) {
			heights.sort((o1, o2) -> o2 - o1); // 由大到小
		}

		List<Integer> answers = new ArrayList<>();
		for (int query : queries) {
			int depth = depths[query];
			int height = heights[query];

			if (depthToHeightGroup.get(depth).size() == 1) {
				answers.add(depthToHeightGroup.get(depth - 1).get(0));
			} else if (depthToHeightGroup.get(depth).get(0) == height) {
				// 要刪掉的是這層的最大值
				// 選擇第二大的遞補
				var answerHeight = depthToHeightGroup.get(depth).get(1);
				answers.add(answerHeight + depth);
			} else if (depthToHeightGroup.get(depth).get(0) != height) {
				// 要刪掉的不是這層的最大值
				// 選擇最大的
				var answerHeight = depthToHeightGroup.get(depth).get(0);
				answers.add(answerHeight + depth);
			}
		}

		int[] resultArray = new int[answers.size()];
		for (int i = 0; i < resultArray.length; i++) {
			resultArray[i] = answers.get(i);
		}
		return resultArray;
	}

	private int traverseHeight(
			TreeNode root,
			int depth
	) {
		if (root == null) {
			return -1;  // we're not counting node, we're counting height
		}

		int height = Math.max(
				traverseHeight(root.left, depth + 1),
				traverseHeight(root.right, depth + 1)
		) + 1;

		depths[root.val] = depth;
		heights[root.val] = height;

		if (depthToHeightGroup.containsKey(depth)) {
			depthToHeightGroup.get(depth).add(height);
		} else {
			List<Integer> heightList = new ArrayList<Integer>();
			heightList.add(height);
			depthToHeightGroup.put(depth, heightList);
		}
		return height;
	}
}
