import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
	public static void main(String[] args) {
		var sampleClass = new ShortestPathInBinaryMatrix();
		// Expected: 4
		int[][] matrix01 = {
				{0, 0, 0},
				{1, 1, 0},
				{1, 1, 0}
		};

		// Expected: 14
		int[][] matrix02 = {
				{0, 1, 1, 0, 0, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 0},
				{0, 0, 0, 1, 1, 0},
				{1, 1, 1, 1, 1, 0},
				{1, 1, 1, 1, 1, 0}
		};

		var result = sampleClass.shortestPathBinaryMatrix(matrix01);
		System.out.println("Result is " + result);
	}

	int[][] directions = new int[][]{
			{-1, -1},
			{-1, 0},
			{-1, 1},
			{0, -1},
			{0, 1},
			{1, -1},
			{1, 0},
			{1, 1}
	};

	private record Pair(int i, int j) {
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		// base case
		if (grid == null || grid.length == 0) {
			return -1;
		}

		// 左上角不是 0，直接跳掉
		if (grid[0][0] == 1) {
			return -1;
		}

		// 右下角不是 0，直接跳掉
		var verticalSize = grid.length - 1;
		var horizontalSize = grid[0].length - 1;
		if (grid[verticalSize][horizontalSize] == 1) {
			return -1;
		}

		// set up values
		Queue<Pair> queue = new LinkedList<>();
		grid[0][0] = 1; // 步數
		queue.offer(new Pair(0, 0));

		// BFS
		while (!queue.isEmpty()) {
			var current = queue.poll();
			// 1.) 現在是否已經是終點？是 -> 回傳 Distance
			// 2.) 否 -> 走八個鄰居，並計算 Distance，把新的點加到 Queue 裡
			var row = current.i;
			var column = current.j;
			var rowSize = grid.length - 1;
			var columnSize = grid[column].length - 1;

			var isLastPosition = column == columnSize && row == rowSize;
			var distance = grid[row][column];

			if (isLastPosition) {
				return distance;
			}

			for (Pair direction : getCurrentPointNeighbors(current, grid)) {
				int nextI = direction.i;
				int nextJ = direction.j;
				grid[nextI][nextJ] = distance + 1;
				queue.offer(new Pair(nextI, nextJ));
			}
		}
		return -1;
	}

	private List<Pair> getCurrentPointNeighbors(Pair pair, int[][] grid) {
		List<Pair> nextDirections = new ArrayList<>();
		for (int[] direction : directions) {
			int nextI = pair.i + direction[0];
			int nextJ = pair.j + direction[1];
			boolean isOutOfBound = nextI < 0 || nextJ < 0 ||
					nextI >= grid.length || nextJ >= grid[nextI].length;

			if (!isOutOfBound) {
				boolean isValidValue = grid[nextI][nextJ] == 0;
				if (isValidValue) {
					nextDirections.add(new Pair(nextI, nextJ));
				}
			}
		}
		return nextDirections;
	}
}
